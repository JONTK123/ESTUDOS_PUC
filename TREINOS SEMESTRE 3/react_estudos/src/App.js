import React from "react";
import './App.css';
import { Greet } from './components/Greet'; // Importe Greet com chaves pois esta escrito na maneira mais concisa
import Welcome from './components/Welcome'; // Importe Welcome sem chaves
import Hello2 from './components/Hello2'; // Importe Hello sem chaves
import Hello1 from './components/Hello1'; // Importe Hello sem chaves
import { Message } from "./components/Message";
import { Incrementador } from "./components/Incrementador";

function App() {
  return (
    <div className="App">

        <Greet estudos = "Props" superEstudos = "2 props agora">
           <p>Esta eh um children props</p>   
        </Greet>

        <Greet estudos = "Props" superEstudos = "2 props agora">
           <button>Esta eh um children props</button>   
        </Greet>

        <Message/>

        <Incrementador/>

        <Welcome/>
        <Hello1/>
        <Hello2/>
    </div>
  );
}

export default App;
