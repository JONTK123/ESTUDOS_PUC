import React from "react";
import './App.css';
import { Greet } from './components/Greet'; // Importe Greet com chaves pois esta escrito na maneira mais concisa
import Welcome from './components/Welcome'; // Importe Welcome sem chaves
import Hello2 from './components/Hello2'; // Importe Hello sem chaves
import Hello1 from './components/Hello1'; // Importe Hello sem chaves

function App() {
  return (
    <div className="App">
        <Greet/>
        <Welcome/>
        <Hello2/>
        <Hello1/>
    </div>
  );
}

export default App;
