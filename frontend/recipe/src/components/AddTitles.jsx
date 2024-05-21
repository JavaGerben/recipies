export default function AddTitles() {
  const submitAddTitle = async function () {
    fetch("http://localhost:8080/api/v1/recipes", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById("addTitle").value,
      }),
    });
  };

  return (
    <>
      <input type="text" id="addTitle"></input>
      <button onClick={submitAddTitle}>submit</button>
    </>
  );
}
