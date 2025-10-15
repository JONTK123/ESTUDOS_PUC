import cv2
import os
from datetime import datetime

NOME = 'Thiago Luiz Fossa'
RA = '23010116'
ESCALA_SAIDA = 0.6


def exibir_janela(imagem):
    cv2.imshow('Imagem', imagem)


def aguardar_saida():
    while True:
        tecla = cv2.waitKey(0) & 0xFF
        if tecla in (27, ord('q'), ord('Q')):
            break
    cv2.destroyAllWindows()


def salvar_imagem(imagem):
    momento = datetime.now().strftime('%Y%m%d_%H%M%S')
    cv2.imwrite(f'{momento}.jpg', imagem)


def obter_caminho_imagem(nome_arquivo):
    return os.path.join(os.path.dirname(__file__), nome_arquivo)


def desenhar_textos(imagem, nome):
    altura, largura = imagem.shape[:2]
    fonte = cv2.FONT_HERSHEY_SIMPLEX
    escala = max(0.8, min(largura, altura) / 600.0)
    espessura = 2
    branco = (255, 255, 255)
    preto = (0, 0, 0)

    (largura_nome, altura_nome), _ = cv2.getTextSize(nome, fonte, escala, espessura)
    x_nome = (largura - largura_nome) // 2
    y_nome = max(20 + altura_nome, altura_nome + 10)
    cv2.putText(imagem, nome, (x_nome, y_nome), fonte, escala, preto, espessura + 2, cv2.LINE_AA)
    cv2.putText(imagem, nome, (x_nome, y_nome), fonte, escala, branco, espessura, cv2.LINE_AA)
    return {
        'fonte': fonte,
        'escala': escala,
        'espessura': espessura,
        'cor_texto': branco,
        'cor_borda': preto,
    }


def desenhar_circulos(imagem):
    altura, largura = imagem.shape[:2]
    branco = (255, 255, 255)
    preto = (0, 0, 0)
    y_centro = altura // 2
    raio = max(10, min(largura, altura) // 12)
    centros = [
        (largura // 4, y_centro),
        (largura // 2, y_centro),
        ((3 * largura) // 4, y_centro),
    ]
    for centro in centros:
        cv2.circle(imagem, centro, raio, branco, -1, cv2.LINE_AA)
        cv2.circle(imagem, centro, raio, preto, 2, cv2.LINE_AA)
    return y_centro, raio


def desenhar_ra(imagem, ra_texto, meta_texto, y_centro, raio):
    altura, largura = imagem.shape[:2]
    fonte = meta_texto['fonte']
    escala = meta_texto['escala']
    espessura = meta_texto['espessura']
    cor_texto = meta_texto['cor_texto']
    cor_borda = meta_texto['cor_borda']

    (larg_ra, alt_ra), _ = cv2.getTextSize(ra_texto, fonte, escala, espessura)
    x_ra = (largura - larg_ra) // 2
    margem = max(10, raio // 3)
    y_ra = y_centro + raio + margem + alt_ra
    cv2.putText(imagem, ra_texto, (x_ra, y_ra), fonte, escala, cor_borda, espessura + 2, cv2.LINE_AA)
    cv2.putText(imagem, ra_texto, (x_ra, y_ra), fonte, escala, cor_texto, espessura, cv2.LINE_AA)


def redimensionar(imagem, escala):
    if escala == 1.0:
        return imagem
    altura, largura = imagem.shape[:2]
    novo_larg = max(1, int(largura * escala))
    novo_alt = max(1, int(altura * escala))
    return cv2.resize(imagem, (novo_larg, novo_alt), interpolation=cv2.INTER_AREA)


def main():
    caminho = obter_caminho_imagem('ponte2.jpg')
    imagem = cv2.imread(caminho)
    if imagem is None:
        raise FileNotFoundError(f'Não foi possível carregar a imagem em: {caminho}')

    meta = desenhar_textos(imagem, NOME)
    y_centro, raio = desenhar_circulos(imagem)
    desenhar_ra(imagem, RA, meta, y_centro, raio)
    imagem_saida = redimensionar(imagem, ESCALA_SAIDA)

    exibir_janela(imagem_saida)
    aguardar_saida()
    salvar_imagem(imagem_saida)


if __name__ == '__main__':
    main()