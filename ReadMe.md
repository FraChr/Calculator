# Simple Calculator
Simple Calculator with GUI and cli version

## Requirements
java 17+ Avaliable on `https://www.java.com/en/`

## To Use
open cmd/terminal in wanted directory<br>
`cd /path/to/dir`<br>
```
git clone https://github.com/FraChr/Calculator.git
```
## Windows
commands: <br>
`cd path/to/gitclone-directory`<br>
```
mvnw.cmd clean install
```
#### CMD Version:
```
java -cp target/classes me.ticster.cli.MainCLI
```
#### GUI Version:
```
mvnw.cmd javafx:run
```
## Linux
commands:
`cd path/to/gitclone-directory`<br>
```
chmod +x mvnw
```
```
./mvnw clean install
```
#### CLI Version:
```
java -cp target/classes me.ticster.cli.MainCLI
```
#### GUI Version:
```
./mvnw javafx:run
```