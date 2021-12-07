/**
 * Using these methods, while the js app is waiting to read files you call isReadReady in a while loop until it returns true, 
 * then you read, then you process the data from loadJSONFromFile.
 * 
 * When you have something from the frontend to send to backend, use saveJSONtoFile with writeFileName
 */

    //this is the file you read into the javascript from the java
const readFileName = "./pipe1.json";

//this is the file you write to the java from here
const writeFileName = "./pipe2.json";

var currentReadTime = 0;


//save the specified obj at the specified path
//return false if unsuccessful, true otherwise.
function saveJSONToFile(path, obj) {
    JSON.stringify(obj);

    //TODO: save and return bool
}

//return the JSON file loaded from the specified path
function loadJSONFromFile(file) {
    
}


//return true iff the file at path that reads into javascript from java is newer than currentReadTime
function isReadReady(path) {

} 

// WHAT I AM WRITING:
// player information, then the people they swipe on

// I AM READING:
// 

export {loadJSONFromFile, saveJSONToFile, isReadReady}