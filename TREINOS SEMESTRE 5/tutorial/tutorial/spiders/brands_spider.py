import scrapy

class BrandsSpider(scrapy.Spider):
    name = "brands"
    start_urls = [
        "https://www.rankingthebrands.com/The-Brands-and-their-Rankings.aspx",
    ]

    def parse(self, response):
        for brand in response.css("div#ctl00_mainContent_brandPanel div.brandLine"):
            yield {
                "Brand": brand.css("span.rankingName::text").get()
            }

        # Coleta os links das letras (A-Z)
        next_letters = response.css("div#ctl00_mainContent_filterPanel a::attr(href)").getall()
        for letter_link in next_letters:
            yield response.follow(letter_link, callback=self.parse)

# Ordem alfabetica
#
# import scrapy
#
# class BrandsSpider(scrapy.Spider):
#     name = "brands"
#     start_urls = [
#         "https://www.rankingthebrands.com/The-Brands-and-their-Rankings.aspx",
#     ]
#
#     def parse(self, response):
#         # Coleta os links das letras (A-Z) e ordena para seguir em ordem alfabética
#         next_letters = sorted(response.css("div#ctl00_mainContent_filterPanel a::attr(href)").getall())
#
#         for letter_link in next_letters:
#             yield response.follow(letter_link, callback=self.parse_letter)
#
#     def parse_letter(self, response):
#         # Extrai os nomes das marcas da página atual, seguindo a ordem de cada letra
#         for brand in response.css("div#ctl00_mainContent_brandPanel div.brandLine"):
#             yield {
#                 "Brand": brand.css("span.rankingName::text").get()
#             }
#
#         # Seguir para a próxima página dentro da mesma letra, se existir
#         next_page = response.css("li.next a::attr(href)").get()
#         if next_page:
#             yield response.follow(next_page, callback=self.parse_letter)
