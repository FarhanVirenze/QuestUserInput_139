import fs from "fs";

// Reading a file synchronously
const buffer = fs.readFileSync("file-system.mjs");
console.info(buffer.toString());

// Writing to a file synchronously
fs.writeFileSync("temp.text", "Hello World");
