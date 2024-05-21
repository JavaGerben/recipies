export default function Ingredients() {
  const submitAddIngredient = async function () {
    fetch("http://localhost:8080/api/v1/ingredients", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: document.getElementById("addIngredient").value,
      }),
    });
  };

  return (
    <>
      <input type="text" id="addIngredient"></input>
      <button onClick={submitAddIngredient}>submit</button>
    </>
  );
}
