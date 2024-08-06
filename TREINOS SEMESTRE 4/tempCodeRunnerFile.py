import matplotlib.pyplot as plt
import numpy as np
import math
import random

print("\n\nCALCULO DOS ANGULOS DE JUNTA:")
# COMPRIMENTO DOS LINKS
L1 = 2
L2 = 1

while True:
 while True:
  try:
   x2=float(input("DIGITE O VALOR DA COORDENADA X DA GARRA: "))
   break
  except:
      print("DIGITE SOMENTE CARACTERES NUMERICOS")
 while True:
  try:   
    y2=float(input("DIGITE O VALOR DA COORDENADA y DA GARRA: "))
    break
  except:
    print("DIGITE SOMENTE CARACTERES NUMERICOS")
 
 #CALCULO DO ANGULO 2
 tt2=math.acos( (x2*x2+y2*y2-L1*L1-L2*L2) / (2.*L1*L2) )
 tt1=math.atan2(y2/x2-(L2*math.sin(tt2))/(L1+L2*math.cos(tt2)), 1+(y2/x2)*( (L2*math.sin(tt2)) / (L1+L2*math.cos(tt2)) ) )
 # tt1=math.atan( (y2/x2-(L2*math.sin(tt2)) / (L1+L2*math.sin(tt2)) )  / (1.+(y2/x2)*( (L2*math.sin(tt2)) / (L1+L2*math.sin(tt2)) ) ) )
 print("ANGULO 1: ",tt1," rad\t",tt1*180./math.pi," Graus")
 print("ANGULO 2: ",tt2," rad\t",tt2*180./math.pi," Graus")
 xx1=L1*math.cos(tt1)
 yy1=L1*math.sin(tt1)
 
 xx2=xx1+L2*math.cos(tt1+tt2)
 yy2=yy1+L2*math.sin(tt1+tt2)
 print("COORDENADA x2 IMPUTADO : ",x2)
 print("COORDENADA y2 IMPUTADO : ",y2)
 print("COORDENADA x2 CALCULADA: ",xx2)
 print("COORDENADA y2 CALCULADA: ",yy2)
 
 fig, ax = plt.subplots()
 fig.canvas.draw()  # Need to draw the figure to define renderer
 ax.set_title("ROBOT")

 p1 = [(0,0), (xx1, yy1)]
 p2 = [(xx1,yy1), (xx2,yy2)]
 line1, = ax.plot(*zip(*p1),color="blue")
 line2, = ax.plot(*zip(*p2),color="blue")
 ax.set_title("POSICAO ROBO")
 ax.set_xlabel("X")
 ax.set_ylabel("Y")
 
 plt.show()
 
 opcao=input("DESEJA REALIZAR OUTRO CALCULO <S/N>:")
 if opcao=="N" or opcao=="n":
     break
 
 
 
 