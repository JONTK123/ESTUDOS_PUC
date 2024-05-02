import React, { useState } from 'react';

export function Message() {
    const [message, setMessage] = useState("Esse eh o valor de message"); //useState eh o valor para message, inicial
    return (  
        <div>
            <h1>{message}</h1> 
            <button onClick={() => setMessage("Ao apertar o botao, ele mudou para isso")}>Apenas um botao para demonstrar como funciona a troca</button> 
        </div>
    )//setMessage muda o valor de message 
}
