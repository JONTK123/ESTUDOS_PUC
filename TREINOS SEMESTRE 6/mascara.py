import cv2
import numpy as np
from datetime import datetime
import os

def salvar(imagem):
    agora = datetime.now()
    nome_arquivo = agora.strftime("%Y%m%d_%H%M%S") + '.jpg'
    cv2.imwrite(nome_arquivo, imagem)
    print(f"Imagem salva como: {nome_arquivo}")

imagem = cv2.imread("ponte2.jpg")

nome = "Thiago"
ra = "12345678"
corBranca = (255, 255, 255)
corAmarela = (0, 255, 255)
h, w = imagem.shape[:2]

nova_largura = int(w * 0.6)
nova_altura = int(h * 0.6)
imagem = cv2.resize(imagem, (nova_largura, nova_altura))
h, w = imagem.shape[:2]

fonte = cv2.FONT_HERSHEY_COMPLEX
fonte_grande = cv2.FONT_HERSHEY_SIMPLEX

mascara = np.zeros((h, w), dtype="uint8")

x1, y1 = int(w*0.65), int(h*0.15)
lado = int(min(w, h)*0.16)
cv2.rectangle(mascara, (x1, y1), (x1+lado, y1+lado), 255, -1)

tri = np.array([
    [int(w*0.35), int(h*0.35)],
    [int(w*0.25), int(h*0.6)],
    [int(w*0.45), int(h*0.6)]
], np.int32)
cv2.fillPoly(mascara, [tri], 255)

cx, cy = int(w*0.7), int(h*0.8)
raio = int(min(w, h)*0.09)
pontos_hex = []
for k in range(6):
    ang = np.deg2rad(60 * k + 0)
    px = int(cx + raio * np.cos(ang))
    py = int(cy + raio * np.sin(ang))
    pontos_hex.append([px, py])
cv2.fillPoly(mascara, [np.array(pontos_hex, np.int32)], 255)

cx_circulo, cy_circulo = int(w*0.2), int(h*0.7)
raio_circulo = int(min(w, h)*0.08)
cv2.circle(mascara, (cx_circulo, cy_circulo), raio_circulo, 255, -1)

centro_elipse = (int(w*0.5), int(h*0.2))
eixos = (int(w*0.1), int(h*0.05))
cv2.ellipse(mascara, centro_elipse, eixos, 0, 0, 360, 255, -1)

resultado = cv2.bitwise_and(imagem, imagem, mask=mascara)

cv2.rectangle(resultado, (int(w*0.45), int(h*0.88)), (int(w*0.95), int(h*0.98)), (0, 0, 0), -1)
cv2.rectangle(resultado, (int(w*0.45), int(h*0.88)), (int(w*0.95), int(h*0.98)), corAmarela, 2)

cv2.putText(resultado, f"Nome: {nome}", (int(w*0.47), int(h*0.92)), fonte_grande, 0.8, corAmarela, 2, cv2.LINE_AA)
cv2.putText(resultado, f"RA: {ra}", (int(w*0.47), int(h*0.96)), fonte_grande, 0.8, corAmarela, 2, cv2.LINE_AA)

salvar(resultado)
