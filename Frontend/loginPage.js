
function generateLoginPage(changePage){

    let log = document.createElement("div");

    let userlabel = document.createElement("node");
    userlabel.textContent = "Username: ";
    log.appendChild(userlabel);

    let b = document.createElement("INPUT");
    b.setAttribute("value", "user123");
    b.setAttribute("label", "Username: ");
    log.appendChild(b);

    let br = document.createElement("br");
    log.appendChild(br);
    let br1 = document.createElement("br");
    log.appendChild(br1);

    let passlabel = document.createElement("node");
    passlabel.textContent = "Password: ";
    log.appendChild(passlabel);

    let pass = document.createElement("INPUT");
    pass.setAttribute("value", "****");
    pass.setAttribute("label", "Password: ");
    log.appendChild(pass);

    let lbutton = document.createElement("button");
    lbutton.textContent = "Login";

    function onLoginClick() {
        changePage("match");
    }
    lbutton.onclick = onLoginClick();
    log.appendChild(lbutton);

    return log;


}


export { generateLoginPage };