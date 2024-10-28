import path from "path";

const file = "/Users/Farhan/Contoh.html";

console.info(path.sep);            // Display the path separator
console.info(path.dirname(file));  // Display the directory name
console.info(path.basename(file)); // Display the base file name
console.info(path.extname(file));  // Display the file extension
console.info(path.parse(file));    // Display an object with parsed path details
