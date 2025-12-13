
// 1. Variables
let userName = "Asritha";
const yearOfBirth = 2005;
var isLoggedIn = true;

// 2. Arrays
let scores = [78, 85, 90, 66, 88];

// push & pop
scores.push(92);
scores.pop();

// map
let updatedScores = scores.map(score => score + 5);

// filter
let passedScores = updatedScores.filter(score => score >= 80);

// reduce
let totalScore = passedScores.reduce((sum, score) => sum + score, 0);

// 3. Objects
const student = {
  name: userName,
  age: new Date().getFullYear() - yearOfBirth,
  scores: passedScores,
  isActive: true
};

// destructuring
const { name, age } = student;

// 4. Functions
function calculateAverage(arr) {
  if (arr.length === 0) return 0;
  return arr.reduce((a, b) => a + b, 0) / arr.length;
}

const averageScore = calculateAverage(student.scores);

// arrow function
const getStatus = avg => avg >= 80 ? "Good" : "Needs Improvement";

// 5. Loops
for (let i = 0; i < scores.length; i++) {
  console.log("Score:", scores[i]);
}

scores.forEach(score => {
  if (score < 70) {
    console.log("Low score detected:", score);
  }
});

// 6. String methods
let message = `Student ${name} has an average score of ${averageScore.toFixed(2)}`;
console.log(message.toUpperCase());

// 7. Array includes & find
let hasPerfectScore = scores.includes(100);
let firstLowScore = scores.find(score => score < 70);//returns element itself when found

// 8. Ternary + logical operators
let accessMessage = isLoggedIn && student.isActive
  ? "Access Granted"
  : "Access Denied";

// 9. Basic try-catch
try {
  JSON.parse("{invalid json}");
} catch (error) {
  console.log("Parsing failed");
}

// 10. Final output
console.log({
  student,
  averageScore,
  status: getStatus(averageScore),
  hasPerfectScore,
  firstLowScore,
  accessMessage
});
