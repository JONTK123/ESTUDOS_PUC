import React from 'react'

const Hello = () => {
    return React.createElement(
        'div',
        {id: 'hello', className: 'ExemploDeClasse2'},
        React.createElement('h1', null, 'Exemplo de JSX arcaico')
        )
}

export default Hello