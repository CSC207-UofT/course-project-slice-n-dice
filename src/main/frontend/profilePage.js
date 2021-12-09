import { REGIONS } from './constants.js';

function validateData(username, phoneNumber, age, region, skill) {
    if (username === "")
        return false;
    if (phoneNumber === "")
        return false;
    if (age === "")
        return false;
    // TODO: instead of region and skill level starting off as "select one", have them set to the first value by default
    // That way we don't need to control those inputs @john
    return true;
}

function validateAndSave() {
    //go through and grab all the input values. validate them, return true iff they're valid.

    //let username = document.getElementById("usernameInput").textContent;
    //console.log("got username: " + username);

    //let phoneNumber = docfument.getElementById("phoneNumberInput").textContent;
    //console.log("got phone number: " + phoneNumber);
    let username = document.getElementById("usernameInput").value;
    let phoneNumber = document.getElementById("phoneNumberInput").value;
    let age = document.getElementById("ageInput").value;
    let bio = document.getElementById("bioInput").value;
    let region = document.getElementById("regionInput").value;
    let skill = document.getElementById("skillLevelInput").value;

    console.log("calling validateAndSave");

    if (!validateData(username, phoneNumber, age, region, skill)) {
        event.preventDefault()
        event.stopPropagation();
        let form = document.getElementById("createProfileForm");
        form.classList.add("was-validated");
        return false;
    }
    else {
        //save data to somehwhere (probably a file, send it to the backend) and then call:
        let dataToSave = {
            username: username,
            phoneNumber: phoneNumber,
            age: age,
            bio: bio
        };
    


        let stringifiedJSON = JSON.stringify(dataToSave)
        
        //tODO: save your data using the file saving method here.
        

        return true; // iff the save was successful

    }
    


}


/**
 * Generates and returns the profile creation page.
 * example of what this code looks like: https://getbootstrap.com/docs/4.0/components/forms/
 * @param {function} changePage the callback to change the current page.
 */
function generateProfilePage(changePage) {
    

    let mainForm = document.createElement("form");
    mainForm.className = "needs-validation";
    mainForm.id = "createProfileForm";
    mainForm.toggleAttribute("novalidate");
    mainForm.addEventListener("submit", (event) => {if (validateAndSave()) changePage("welcome")}); //tells the form to call validateAndSave when submit is clicked.

    //begin username
    let usernameFormGroup = document.createElement("div");
    usernameFormGroup.className = "form-group";

    let usernameInputId = "usernameInput";
    let usernameLabel = document.createElement("label");
    usernameLabel.className = "form-label";
    usernameLabel.setAttribute("for", usernameInputId);
    usernameLabel.textContent = "Username:";

    let usernameInput = document.createElement("input");
    usernameInput.type = "text";
    usernameInput.id = usernameInputId;
    usernameInput.className = "form-control";
    usernameInput.setAttribute("aria-describedby", "usernameHelp");
    usernameInput.placeholder = "Enter username...";
    usernameInput.toggleAttribute("required");

    let invalidUsernameFeedback = document.createElement("div");
    invalidUsernameFeedback.className = "invalid-feedback";
    invalidUsernameFeedback.textContent = "Please choose a username";

    usernameFormGroup.appendChild(usernameLabel);
    usernameFormGroup.appendChild(usernameInput);
    usernameFormGroup.appendChild(invalidUsernameFeedback);
    //end username

    //begin phone number
    let phoneNumberFormGroup = document.createElement("div");
    phoneNumberFormGroup.className = "form-group";

    let phoneNumberInputId = "phoneNumberInput";
    let phoneNumberLabel = document.createElement("label");
    phoneNumberLabel.className = "form-label";
    phoneNumberLabel.setAttribute("for", phoneNumberInputId);
    phoneNumberLabel.textContent = "Phone Number:";

    let phoneNumberInput = document.createElement("input");
    phoneNumberInput.type = "text";
    phoneNumberInput.id = phoneNumberInputId;
    phoneNumberInput.className = "form-control";
    phoneNumberInput.setAttribute("aria-describedby", "phoneNumberHelp");
    phoneNumberInput.placeholder = "Enter Phone Number...";
    phoneNumberInput.toggleAttribute("required");

    let invalidPhoneNumberFeedback = document.createElement("div");
    invalidPhoneNumberFeedback.className = "invalid-feedback";
    invalidPhoneNumberFeedback.textContent = "Please enter a phone number";

    phoneNumberFormGroup.appendChild(phoneNumberLabel);
    phoneNumberFormGroup.appendChild(phoneNumberInput);
    phoneNumberFormGroup.appendChild(invalidPhoneNumberFeedback);
    //end phone number
    
    //begin age
    let ageFormGroup = document.createElement("div");
    ageFormGroup.className = "form-group";

    let ageInputId = "ageInput";
    let ageLabel = document.createElement("label");
    ageLabel.className = "form-label";
    ageLabel.setAttribute("for", ageInputId);
    ageLabel.textContent = "Age:";

    let ageInput = document.createElement("input");
    ageInput.type = "number";
    ageInput.id = ageInputId;
    ageInput.className = "form-control";
    ageInput.setAttribute("aria-describedby", "ageHelp");
    ageInput.placeholder = "";
    ageInput.toggleAttribute("required");

    let invalidAgeFeedback = document.createElement("div");
    invalidAgeFeedback.className = "invalid-feedback";
    invalidAgeFeedback.textContent = "Please enter your age";

    ageFormGroup.appendChild(ageLabel);
    ageFormGroup.appendChild(ageInput);
    ageFormGroup.appendChild(invalidAgeFeedback);
    //end age

    //begin bio
    let bioFormGroup = document.createElement("div");
    bioFormGroup.className = "form-group";

    let bioInputId = "bioInput";
    let bioLabel = document.createElement("label");
    bioLabel.className = "form-label";
    bioLabel.setAttribute("for", bioInputId);
    bioLabel.textContent = "Bio:";

    let bioInput = document.createElement("textarea");
    bioInput.id = bioInputId;
    bioInput.className = "form-control";
    bioInput.setAttribute("aria-describedby", "bioHelp");
    bioInput.placeholder = "Enter bio...";
    bioInput.toggleAttribute("required");

    bioFormGroup.appendChild(bioLabel);
    bioFormGroup.appendChild(bioInput);
    //end bio

    //begin region select
    let regionFormGroup = document.createElement("div");
    regionFormGroup.className = "form-group";

    let regionFormGroupId = "regionInput";
    let regionLabel = document.createElement("label");
    regionLabel.className = "form-label";
    regionLabel.setAttribute("for", regionFormGroupId);
    regionLabel.textContent = "Select Region:";

    let regionInput = document.createElement("div");
    regionInput.className = "dropdown";
    regionInput.id = regionFormGroupId;

    let regionDropdownButtonId = "regionDropdownButton";
    let regionDropdownButton = document.createElement("button");
    regionDropdownButton.type = "button";
    regionDropdownButton.className = "btn btn-primary dropdown-toggle";
    regionDropdownButton.id = regionDropdownButtonId;
    regionDropdownButton.setAttribute("data-bs-toggle", "dropdown");
    regionDropdownButton.setAttribute("aria-expanded", "false");
    regionDropdownButton.textContent = "Select an option..."; //initial value is the first region
    regionDropdownButton.toggleAttribute("required");

    let regionDropdownMenu = document.createElement("ul");
    regionDropdownMenu.className = "dropdown-menu";
    regionDropdownMenu.setAttribute("aria-labelledby", regionDropdownButtonId);

    //for hacking around bootstrap we have our own onclick wrapper to change the text of the button
    //     when an option is clicked

    function changeRegionDropdownButtonText(text) {
        document.getElementById(regionDropdownButtonId).textContent = text;
    }

    for (let i = 0; i < REGIONS.length; i++) {
        let regionListItem = document.createElement("li");
        let region = document.createElement("a");
        region.className = "dropdown-item";
        region.href = "#";
        region.textContent = REGIONS[i];
        region.onclick = () => changeRegionDropdownButtonText(REGIONS[i]);
        regionListItem.appendChild(region);
        regionDropdownMenu.appendChild(regionListItem);
    }


    regionInput.appendChild(regionDropdownButton);
    regionInput.appendChild(regionDropdownMenu);

    regionFormGroup.appendChild(regionLabel);
    regionFormGroup.appendChild(regionInput);
    //end region select

    //begin skill level select
    let skillLevelFormGroup = document.createElement("div");
    skillLevelFormGroup.className = "form-group";

    let skillLevelFormGroupId = "skillLevelInput";
    let skillLevelLabel = document.createElement("label");
    skillLevelLabel.className = "form-label";
    skillLevelLabel.setAttribute("for", skillLevelFormGroupId);
    skillLevelLabel.textContent = "Select your skill level (on a scale from 1.0 to 7.0, according to the NTRP Tennis Player Rating Scale):";

    let skillLevelInput = document.createElement("div");
    skillLevelInput.className = "dropdown";
    skillLevelInput.id = skillLevelFormGroupId;

    let skillLevelDropdownButtonId = "skillLevelDropdownButton";
    let skillLevelDropdownButton = document.createElement("button");
    skillLevelDropdownButton.type = "button";
    skillLevelDropdownButton.className = "btn btn-primary dropdown-toggle";
    skillLevelDropdownButton.id = skillLevelDropdownButtonId;
    skillLevelDropdownButton.setAttribute("data-bs-toggle", "dropdown");
    skillLevelDropdownButton.setAttribute("aria-expanded", "false");
    skillLevelDropdownButton.textContent = "Select an option..."; //initial value is 1
    skillLevelDropdownButton.toggleAttribute("required");

    let skillLevelDropdownMenu = document.createElement("ul");
    skillLevelDropdownMenu.className = "dropdown-menu";
    skillLevelDropdownMenu.setAttribute("aria-labelledby", skillLevelDropdownButtonId);

    //for hacking around bootstrap we have our own onclick wrapper to change the text of the button
    //     when an option is clicked

    function changeSkillLevelDropdownButtonText(text) {
        document.getElementById(skillLevelDropdownButtonId).textContent = text;
    }

    for (let i = 1.0; i < 7.0; i = i + 0.5) {
        let skillLevelListElem = document.createElement("li");
        let skillLevel = document.createElement("a");
        skillLevel.className = "dropdown-item";
        skillLevel.href = "#";
        skillLevel.textContent = i.toString();
        skillLevel.onclick = () => changeSkillLevelDropdownButtonText(i.toString());
        skillLevelListElem.appendChild(skillLevel);
        skillLevelDropdownMenu.appendChild(skillLevelListElem);
    }

    skillLevelInput.appendChild(skillLevelDropdownButton);
    skillLevelInput.appendChild(skillLevelDropdownMenu);

    skillLevelFormGroup.appendChild(skillLevelLabel);
    skillLevelFormGroup.appendChild(skillLevelInput);
    //end skill level select

    //begin availability button group
    let availabilityFormGroup = document.createElement("div");
    availabilityFormGroup.className = "form-group";

    let availabilityButtonGroupId = "availabilityButtonGroup";
    let availabilityLabel = document.createElement("label");
    availabilityLabel.className = "form-label";
    availabilityLabel.setAttribute("for", availabilityButtonGroupId);
    availabilityLabel.textContent = "Check all days when you are available:";

    let availabilityButtonGroup = document.createElement("div");
    availabilityButtonGroup.id = availabilityButtonGroupId;
    availabilityButtonGroup.className = "btn-group";
    availabilityButtonGroup.setAttribute("role", "group");
    availabilityButtonGroup.setAttribute("aria-label", "Availability Selection");

    ["Mondays", "Tuesdays", "Wednesdays", "Thursdays", "Fridays", "Saturdays", "Sundays"].forEach((weekDay) => {
        let dayButton = document.createElement("button");
        dayButton.type = "button";
        dayButton.className = "btn btn-secondary";
        dayButton.textContent = weekDay;
        dayButton.id = "availability" + weekDay;
        dayButton.onclick = () => {
            if (dayButton.className == "btn btn-success")
                dayButton.className = "btn btn-secondary";
            else 
                dayButton.className = "btn btn-success";
        };
        availabilityButtonGroup.appendChild(dayButton);
    });

    availabilityFormGroup.appendChild(availabilityLabel);
    availabilityFormGroup.appendChild(availabilityButtonGroup);
    //end availability button group

    //begin submit button
    let submitButton = document.createElement("button");
    submitButton.className = "btn btn-primary form-control";
    submitButton.type = "submit";
    submitButton.textContent = "Submit"
    //end submit button

    //begin back button
    let backButton = document.createElement("button");
    backButton.className = "btn btn-primary form-control";
    backButton.onclick = () => changePage("start");
    backButton.textContent = "Back";
    //end back button

    mainForm.appendChild(usernameFormGroup);
    mainForm.appendChild(phoneNumberFormGroup);
    mainForm.appendChild(ageFormGroup);
    mainForm.appendChild(bioFormGroup);
    mainForm.appendChild(regionFormGroup);
    mainForm.appendChild(skillLevelFormGroup);
    mainForm.appendChild(availabilityFormGroup);
    mainForm.appendChild(backButton);
    mainForm.appendChild(submitButton);


    return mainForm;

   
}

export { generateProfilePage };