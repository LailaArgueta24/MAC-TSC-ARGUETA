import { useState } from "react";
import PrimerComponente from "./components/primerComponente.jsx";
import Fruit from "./components/Fruit.jsx";
function App() {
  const [fruits, setFruits] = useState(["Apple", "Banana", "Orange"]);
  return (
    <div>
      <Fruit fruits={fruits}></Fruit>
    </div>
  );
}

export default App;
