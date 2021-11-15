import {generateStartPage} from './startPage.js';
import {generateLoginPage} from './loginPage.js';
import {generateProfilePage} from './profilePage.js';
 
let pageTypeDict = {
    "start": null,
    "makeprofile": null,
    "login": null,
    "match": null
};

let name = null;
let dob = null;

function receivedForm() {

}


//pageType is a string
function changePage(pageType) {
    document.body.replaceChildren(pageTypeDict[pageType]);
}


function generateMatchPage(){

    let m = document.createElement("div");

    let editprofile = document.createElement("button");
    editprofile.textContent = "Edit Profile";          

    function onButtonClick() {
        changePage("makeprofile");
    }
    editprofile.onclick = onButtonClick;

    m.appendChild(editprofile);
}



//runs when the application starts
function main() {
    console.log("calling main");
    pageTypeDict["start"] = generateStartPage(changePage);
    pageTypeDict["makeprofile"] = generateProfilePage(changePage);
    pageTypeDict["login"] = generateLoginPage(changePage);
    pageTypeDict["match"] = generateMatchPage();

    document.body.replaceChildren(pageTypeDict["start"]);
}

console.log("running tennis.js");


main();


