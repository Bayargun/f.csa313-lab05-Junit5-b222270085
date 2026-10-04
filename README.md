# Лаборатори №4 — Нэгжийн тестийн эхлэл: JUnit 5

**Хичээл:** F.CSA313 — Программ хангамжийн чанарын баталгаа ба тест  
**Оюутны нэр:** Б. Баяргүн  
**Оюутны код:** B222270085

## Орчны мэдээлэл

### Java version

```text
java -version "17.0.20.1"
```

### Maven version

```text
mvn -version
Apache Maven 3.9.12
Maven home: /usr/share/maven
Java version: 17.0.20.1, vendor: Ubuntu, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "7.0.0-31-generic", arch: "amd64", family: "unix"
```

## Төслийн тухай

Энэ лабораторийн ажлаар Maven болон JUnit 5 ашиглан `GradeCalculator` класст нэгжийн тест бичсэн. `letterGrade()` метод нь 0-100 хүртэлх онооноос A, B, C, D, F үсгэн дүн тооцдог. `totalScore()` метод нь ирц, лаборатори ба бие даалт, хоёр сорил болон шалгалтын оноог нийлүүлж нийт оноо тооцдог. Зөвшөөрөгдсөн хязгаараас гарсан оролтуудад `IllegalArgumentException` хийсэн.

## Test Results

Нийт тестийн методын тоо: **18**

`results/mvn-test.txt` дахь Maven/Surefire-ийн тоолсон тестийн тоо:

```text
Tests run: 28, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Parameterized тестийн `@CsvSource`-ийн мөр бүрийг Surefire тусдаа тест гэж тоолдог учраас тестийн методын тоо болон `Tests run` тоо ялгаатай байна.

## Mutation Test

`GradeCalculator.letterGrade()` методын:

```java
score >= 90
```

нөхцөлийг зориуд:

```java
score > 90
```

болгон өөрчилж mutation test хийсэн.

Mutation test-ийн үр дүн:

```text
Tests run: 28, Failures: 2, Errors: 0, Skipped: 0
BUILD FAILURE
```

Унасан тестүүд:

- `GradeCalculatorTest.letterGradeBoundaries` — expected: `A`, but was: `B`
- `GradeCalculatorTest.ninetyIsExactlyA` — expected: `A`, but was: `B`

Mutation test-ийн гаралтыг `results/mvn-test-mutant.txt` файлд хадгалсан. Туршилтын дараа `score >= 90` нөхцөлийг буцааж сэргээж, бүх тестийг дахин ажиллуулахад 28 тест бүгд амжилттай болсон.

## Дүгнэлт

Энэ лабораторийн ажлаар JUnit 5 ашиглан нэгжийн тест бичиж, assertion болон parameterized тест ашиглаж сурлаа. `GradeCalculator` классын ердийн болон хязгаарын утгуудыг тусад нь шалгасан. Мөн буруу оролтуудад `assertThrows` ашиглан `IllegalArgumentException` үүсэж байгаа эсэхийг шалгасан. `@ParameterizedTest` болон `@CsvSource` ашигласнаар ижил логиктой олон оролтыг нэг тестийн методоор шалгах боломжтой болсон. Mutation test хийхдээ `score >= 90` нөхцөлийг `score > 90` болгож өөрчлөхөд 90 оноог шалгасан хоёр тест алдааг илрүүлсэн. Миний хувьд `ninetyIsExactlyA` тест хамгийн сонирхолтой байсан, учир нь ердөө `>=` тэмдгийг `>` болгон өөрчлөхөд хязгаарын жижиг алдааг шууд илрүүлсэн. Энэ нь boundary value тестүүд бодит программын жижиг боловч чухал алдааг илрүүлэхэд хэрэгтэйг харуулсан.
