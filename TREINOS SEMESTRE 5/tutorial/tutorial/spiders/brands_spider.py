import scrapy
import csv
from pymongo import MongoClient

MONGO_URI = "mongodb+srv://thiagofossa433:irsIXyB3A5V0tY7X@aulasbd.p8nc1.mongodb.net/"
DATABASE_NAME = "Scrapy"
COLLECTION_DATA = "Data"
client = MongoClient(MONGO_URI)
db = client[DATABASE_NAME]


class BrandsSpider(scrapy.Spider):
    name = "brands"
    start_urls = [
        "https://www.rankingthebrands.com/The-Brands-and-their-Rankings.aspx",
    ]
    all_brands = []

    def parse(self, response):
        data_to_insert = []
        for brand in response.css("div#ctl00_mainContent_brandPanel div.brandLine"):
            brand_name = brand.css("span.rankingName::text").get()
            data_to_insert.append({"Brand": brand_name})
            self.all_brands.append(brand_name)
            yield {"Brand": brand_name}

        # Coleta os links das letras (A-Z)
        next_letters = response.css("div#ctl00_mainContent_filterPanel a::attr(href)").getall()
        for letter_link in next_letters:
            yield response.follow(letter_link, callback=self.parse)

        # db[COLLECTION_DATA].insert_many(data_to_insert)

    def closed(self, reason):
        if self.all_brands:
            db[COLLECTION_DATA].insert_one({"All_Brands": self.all_brands})

            # Escreve os dados em um arquivo CSV
            with open("brands.csv", mode="w", newline="", encoding="utf-8") as file:
                writer = csv.writer(file)
                writer.writerow(["Brand"])  # Cabeçalho
                for brand in self.all_brands:
                    writer.writerow([brand])
