function generateStartPage(changePage) {

    // Create main container
    let mainContainer = document.createElement("div");
    mainContainer.className = "container-fluid";

    let mainRow = document.createElement("div");
    mainRow.className = "row";

    let mainColumn = document.createElement("div");
    mainColumn.className = "col-12";

    let titleText = document.createElement("div");
    mainColumn.id = "titleText";
    mainColumn.textContent = "Match Finder";

    mainColumn.appendChild(titleText);

    mainRow.appendChild(mainColumn);

    let buttonRow = document.createElement("div");
    buttonRow.className = "row";

    function onMakeProfileButtonClick() {
        changePage("makeprofile");
    }

    function onLoginButtonClick() {
        changePage("login");
    }

    let createProfileButton = document.createElement("button");
    createProfileButton.type = "button";
    createProfileButton.className = "btn btn-primary";
    createProfileButton.onclick = onMakeProfileButtonClick;
    createProfileButton.textContent = "Create a Profile";

                                                        
    let loginButton = document.createElement("button");
    loginButton.type = "button";
    loginButton.className = "btn btn-warning";
    loginButton.onclick = onLoginButtonClick;
    loginButton.textContent = "Login";

    buttonRow.appendChild(createProfileButton);

    buttonRow.appendChild(loginButton);

    mainContainer.appendChild(mainRow);

    mainContainer.appendChild(buttonRow);  

    return mainContainer;

}


export { generateStartPage };