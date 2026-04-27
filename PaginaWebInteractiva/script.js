function cambiaColor() {
  const colorAleatorio =
    "#" + Math.floor(Math.random() * 16777215).toString(16);
  document.body.style.backgroundColor = colorAleatorio;
}
function saludo() {
  alert("HOLAAA<3");
}
