## Test Results

JUnit 5 тестүүдийг Maven ашиглан ажиллуулсан.

- Tests run: 28
- Failures: 0
- Errors: 0
- Skipped: 0
- Result: BUILD SUCCESS

Тестийн бүрэн гаралтыг `results/mvn-test.txt` файлд хадгалсан.

## Mutation Test

`GradeCalculator.letterGrade()` методын `score >= 90` нөхцөлийг
зориуд `score > 90` болгон өөрчилж mutation test хийсэн.

Mutation test-ийн үр дүн:

- Tests run: 28
- Failures: 2
- Errors: 0
- Skipped: 0
- Result: BUILD FAILURE

Унасан тестүүд:

1. `GradeCalculatorTest.letterGradeBoundaries`
   - Expected: `A`
   - Actual: `B`

2. `GradeCalculatorTest.ninetyIsExactlyA`
   - Expected: `A`
   - Actual: `B`

Эдгээр тестүүд нь 90 онооны хязгаарын нөхцөлийг шалгаж байсан тул
`>= 90` нөхцөлийг `> 90` болгож өөрчлөхөд алдааг амжилттай илрүүлсэн.

Mutation test-ийн гаралтыг `results/mvn-test-mutant.txt` файлд хадгалсан.

Дараа нь нөхцөлийг `score >= 90` болгон буцааж засаж,
тестүүдийг дахин ажиллуулахад бүх 28 тест амжилттай болсон.
