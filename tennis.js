import {generateStartPage} from './startPage.js';
import { generateWelcomePage } from './welcome.js';
import {generateLoginPage} from './loginPage.js';
import {generateProfilePage} from './profilePage.js';
import {generateMatchPage} from './matchPage.js';
import {generateStatsPage} from './statsPage.js';
import {generateEditProfilePage} from './editprofile.js';
 
let pageTypeDict = {
    "start": null,
    "makeprofile": null,
    "login": null,
    "match": null,
    "stats": null,
    "edit": null,
    "welcome": null
};


//pageType is a string
function changePage(pageType) {
    document.body.replaceChildren(pageTypeDict[pageType]);
}


//runs when the application starts
function main() {
    console.log("calling main");
    pageTypeDict["start"] = generateStartPage(changePage);
    pageTypeDict["makeprofile"] = generateProfilePage(changePage);
    pageTypeDict["login"] = generateLoginPage(changePage);
    pageTypeDict["match"] = generateMatchPage(changePage);
    pageTypeDict["stats"] = generateStatsPage(changePage);
    pageTypeDict["edit"] = generateEditProfilePage(changePage);
    pageTypeDict['welcome'] = generateWelcomePage(changePage);

    document.body.replaceChildren(pageTypeDict["start"]);
}

console.log("running tennis.js");


main();


