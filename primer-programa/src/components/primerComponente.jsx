import React, { useState } from "react";

const PrimerComponente = () => {
  //let nombre = "Laila";
  let numero = [1, 2, 3, 4];
  const [nombre, setNombre] = useState("Laila");

  const cambiarNombre = (nuevoNombre) => {
    setNombre(nuevoNombre);
  };
  return (
    <div>
      <h1>Hola</h1>
      <p>
        Mi nombre es:
        <strong className={nombre.length >= 4 ? "verde" : "rojo"}>
          {nombre}
        </strong>
      </p>
      <button onClick={(e) => cambiarNombre("Akari")}>Cambiar nombre</button>
      <input
        type="text"
        onChange={(e) => cambiarNombre(e.target.value)}
        placeholder="escribe un nombre"
      />

      <ul>
        {numero.map((numero, indice) => {
          return <li key={indice}>{numero}</li>;
        })}
      </ul>
    </div>
  );
};

export default PrimerComponente;
