/**
 * Using these methods, while the js app is waiting to read files you call isReadReady in a while loop until it returns true, 
 * then you read, then you process the data from loadJSONFromFile.
 * 
 * When you have something from the frontend to send to backend, use saveJSONtoFile with writeFileName
 */

var currentReadTime = 0;

var buffer = "";

const ip = "127.0.0.1";
const port = 6060;


//save the specified obj at the specified path
//return false if unsuccessful, true otherwise.
function saveJSONToFile(data) {
    var request = new XMLHttpRequest();

    request.open("POST", "http://" + ip + ":" + port, true);
    request.setRequestHeader("Content-type", "text/plain")
    request.onload = function () {
        if(request.readyState === 4 && request.status === 201) {
            console.log("successfully sent to server: ", data);
        }
    }
    
    request.send(data);
}

//load the file. Return null if timeout or failure.
function loadJSONFromFile(file)
{
    buffer = "";
    var request = new XMLHttpRequest();
    let timeout = 3000;
    let date = new Date();
    let readStartTime = date.getMilliseconds();
    request.open("GET", "http://" + ip + ":" + port, false);
    request.onreadystatechange = function ()
    {
        if(request.readyState === 4)
        {
            if(request.status === 200 || request.status == 0)
            {
                buffer = request.responseText;
               
            }
        }
    }
    
    request.send();
    while (request.readyState !== 4) {
        if (date.getMilliseconds() < readStartTime + timeout){
            console.log("ERROR: Timeout when trying to read file: ", file);
            return null;
        }
    };

    console.log(buffer);
    return buffer;
}


//return true iff the file at path that reads into javascript from java is newer than currentReadTime
function isReadReady(path) {

} 

export {loadJSONFromFile, saveJSONToFile, isReadReady}