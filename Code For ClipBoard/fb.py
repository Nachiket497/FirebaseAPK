from firebase import firebase
import requests
import tkinter as tk
from tkinter import*


firebase = firebase.FirebaseApplication("https://assignment2-35d2c.firebaseio.com/DATA",None)
result = firebase.get("/DATA",None)
print(result)
st = result["DATA"]


import PySimpleGUI as sg


layout = [
           [sg.Multiline(st, autoscroll=True,key ='_DISPLAY_',size=(200,100),background_color="black",text_color="white"  )]
              
            ]

window = sg.Window("Clipboard",layout=layout ,background_color="#000000",size=(400,500))


while True :
    
    event , values = window.read(timeout=20)    
   
    result = firebase.get("/DATA",None)
    st = result["DATA"]    
    print(st)
    window['_DISPLAY_'].update(st)
    window.refresh()
window.close()




