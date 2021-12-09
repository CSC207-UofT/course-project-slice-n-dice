import http, { request } from 'http';
import fs from 'fs';

//this is the file you read into the javascript from the java
const readFileName = "./pipe1.json";

const statsReadFileName = "statspipe1.json";

//this is the file you write to the java from here
const writeFileName = "./pipe2.json";

const statsWriteFileName = "statspipe2.json";


var wins = 0;

var losses = 0;

const server = http.createServer((req, res) => {

    if (req.method == "POST"){
        req.on("data", (rawData) => {
            let data = rawData.toString();
            if (data.includes("win")) {
                //data is "win:<num_wins>"
                console.log("detected win");
                wins++;
                let jsonToWrite = {
                    "wins": wins.toString(),
                    "losses": losses.toString()
                };
                console.log("win recorded! Writing: " + JSON.stringify(jsonToWrite) );
                fs.writeFileSync(statsWriteFileName, JSON.stringify(jsonToWrite));
                
                res.writeHead(201);
                res.end("Recieved");
            }
            else if (data.includes("loss")) {
                losses++;
                let jsonToWrite = {
                    "wins": wins,
                    "losses": losses
                };
                fs.writeFileSync(statsWriteFileName, JSON.stringify(jsonToWrite));
                
                res.writeHead(201);
                res.end("Recieved");
            }
            else {
                //TODO: Write to profile thing.
            }
        });
    }
    else if (req.method == "GET") {

        let fileContent = fs.readFileSync(statsReadFileName);
        let fileJSON = JSON.parse(fileContent);
        fileJSON["wins"] = wins.toString();
        fileJSON["losses"] = losses.toString();

        console.log("sending the json data to client");
        res.writeHead(200, {"Content-type": "text/plain", "Access-Control-Allow-Origin": "http://localhost:8080"});
        res.end(JSON.stringify(fileJSON));
    }

}).listen(6060, "127.0.0.1");
console.log("Server started. Listening on 127.0.0.1:6060");