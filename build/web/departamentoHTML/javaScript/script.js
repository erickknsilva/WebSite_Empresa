const content = document.querySelector(".content");
const inputSearch = document.querySelector("input[type='search']");

let items = [];

inputSearch.oninput = () => {
    content.innerHTML = "";

    items.filter((item) =>
        item.toLowerCase().includes(inputSearch.value.toLowerCase())
    )
            .forEach((item) => addHTML(item));
};

function addHTML(item) {
    const div = document.createElement("a");
    div.innerHTML = item;
    content.append(div);
}

fetch("http://localhost:8080/WebSite/newServlet")
        .then((data) => data.json())
        .then((departamentos) => {
            departamentos.forEach((departamento) => {
                addHTML(departamento.Id);
                addHTML(departamento.nomeDepartamento);
                addHTML(departamento.telefone);
                items.push(departamento.Id + ' - ' + departamento.nomeDepartamento);
            });
        });