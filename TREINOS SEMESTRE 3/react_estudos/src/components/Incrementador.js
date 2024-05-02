import React, { useState } from 'react';

export function Incrementador() {
    const [count, setCount] = useState(0);
    return (
        <div>
            <h1>Valor inicial: {count}</h1>
            <button onClick={() => setCount(count + 1)}>Incrementar</button>
        </div>
    )
}

