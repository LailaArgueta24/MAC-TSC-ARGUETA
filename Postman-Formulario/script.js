async function cargarPaises() {
  try {
    const response = await fetch(
      "https://restcountries.com/v3.1/all?fields=name,flags",
    );
    const data = await response.json();

    const select = document.getElementById("pais");

    // Ordenar alfabéticamente
    data.sort((a, b) => a.name.common.localeCompare(b.name.common));

    data.forEach((pais) => {
      const option = document.createElement("option");
      option.value = pais.name.common;
      option.textContent = pais.name.common;
      select.appendChild(option);
    });
  } catch (error) {
    console.error("Error al cargar países:", error);
  }
}

function validar() {
  let valido = true;

  const nombre = document.getElementById("nombre").value.trim();
  const lastName = document.getElementById("lastName").value.trim();
  const email = document.getElementById("email").value.trim();
  const account = document.getElementById("account").value.trim();
  const avg = document.getElementById("avg").value.trim();
  const pais = document.getElementById("pais").value;

  // Limpiar errores
  document.getElementById("errorNombre").textContent = "";
  document.getElementById("errorLastName").textContent = "";
  document.getElementById("errorEmail").textContent = "";
  document.getElementById("errorAccount").textContent = "";
  document.getElementById("errorAvg").textContent = "";
  document.getElementById("errorPais").textContent = "";

  if (nombre === "") {
    document.getElementById("errorNombre").textContent =
      "El nombre es obligatorio";
    valido = false;
  }

  if (lastName === "") {
    document.getElementById("errorLastName").textContent =
      "El apellido es obligatorio";
    valido = false;
  }

  if (email === "") {
    document.getElementById("errorEmail").textContent =
      "El email es obligatorio";
    valido = false;
  } else if (!/\S+@\S+\.\S+/.test(email)) {
    document.getElementById("errorEmail").textContent =
      "Formato de email inválido";
    valido = false;
  }

  if (account === "") {
    document.getElementById("errorAccount").textContent =
      "La cuenta es obligatoria";
    valido = false;
  }

  if (avg === "") {
    document.getElementById("errorAvg").textContent =
      "El promedio es obligatorio";
    valido = false;
  }

  if (pais === "") {
    document.getElementById("errorPais").textContent =
      "Debe seleccionar un país";
    valido = false;
  }

  return valido;
}

async function guardar() {
  if (!validar()) return;

  const formData = new FormData();

  formData.append("name", document.getElementById("nombre").value.trim());
  formData.append("lastName", document.getElementById("lastName").value.trim());
  formData.append("email", document.getElementById("email").value.trim());
  formData.append("account", document.getElementById("account").value.trim());
  formData.append("avg", document.getElementById("avg").value.trim());
  formData.append("country", document.getElementById("pais").value);

  try {
    const response = await fetch("https://masksoft.com.mx/register", {
      method: "POST",
      body: formData,
    });

    const resultado = await response.json();

    console.log("Respuesta del servidor:", resultado);

    if (resultado.status === "success") {
      alert("Guardado correctamente");
      limpiar();
    } else {
      alert("Error: " + resultado.message);
    }
  } catch (error) {
    console.error("Error al enviar datos:", error);
    alert("Error de conexión con el servidor");
  }
}

function limpiar() {
  document.getElementById("formulario").reset();

  document.getElementById("errorNombre").textContent = "";
  document.getElementById("errorLastName").textContent = "";
  document.getElementById("errorEmail").textContent = "";
  document.getElementById("errorAccount").textContent = "";
  document.getElementById("errorAvg").textContent = "";
  document.getElementById("errorPais").textContent = "";
}

window.onload = cargarPaises;
