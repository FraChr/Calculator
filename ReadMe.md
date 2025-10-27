# Simple Calculator
Simple Calculator with GUI and cli version
## installation
open cmd/terminal in wanted directory
`cd /path/to/dir`
`command: git clone https://github.com/FraChr/Calculator.git`
### Windows
commands: 
`cd path/to/gitclone-directory`
`mvnw.cmd clean install`
#### CMD Version:
`java -cp target/classes me.ticster.cli.MainCLI`
#### GUI Version:
`mvnw.cmd javafx:run`
### Linux
commands:
`cd path/to/gitclone-directory`
`chmod +x mvnw`
`./mvnw clean install`
#### CLI Version:
`java -cp target/classes me.ticster.cli.MainCLI`
#### GUI Version:
`./mvnw javafx:run`