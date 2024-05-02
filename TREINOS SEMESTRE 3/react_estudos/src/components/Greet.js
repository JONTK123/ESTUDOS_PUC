import React from "react";

//Jeito longo de escrever a funcao
// export function Greet() { 
//     return <h1>Hello pirocao</h1>
//}

//Jeito + curto de escrever a funcao
// const Greet = (props) => <h1>Fun component</h1>;
// export default Greet; //Jeito completo de exportar a funcao
//ou
// export const Greet = (props) => <h1>Fun component</h1>;

//Jeito + curto aceitando mais termos na funcao 
// export const Greet = (props) => {
//     console.log(props)
//     return  <h1>Fun component {props.estudos} and {props.superEstudos}</h1>; //props eh para acessar propiedades do componente pai / html / div do app.js
// }

// para usar PROPS CHILDREN -> props.children
export const Greet = (props) => {
    //props.name = "wukong" -> Isso nao funciona pois props eh imutavel...
    return ( //So podemos retornar um elemnto HTML -> transformar em uma div
        <div>
            <h1>Fun component {props.estudos} and {props.superEstudos}</h1>
            {props.children}
        </div>
    )
}