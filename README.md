# Q-Manager
A questionnaire manager.

## Structure 

A questionnaire has the following structure:
 - Questionnaire
 - QuestionnaireGroup
 - Group
 - GroupSection
 - Section
 - SectionQuestion
 - Question

## Description

Every question can be translated in different languages thanks to the Translation table.
 
A Questionnaire consists of one or more groups. A group consists of one or more sections and a section consists of one or more questions.

This subdivision allows you to enter a title and a help text at the questionnaire, group or section level.

At the graphic level, a questionnaire is a set of tabs. A group is represented by a tab and a section is a set of questions.

Each group, section or question has an order with respect to its parent. Therefore the groups can be ordered on the basis of the order property of the relationship table between the questionnaire and the group. The same logic applies to the section and to the questions.

## Running

To start the applciation:

	mvn clean package
	
To run the application:
	
	java -jar q-manager.jar
	
### Command line
To create a Questionnaire:

	questionnaire create TITLE HELP LANGUAGE_CODE

Where:
 - `TITLE` is the title of your questionnaire
 - `HELP` is the text that describes the questionnaire
 - `LANGUAGE_CODE` the language code of the `TITLE` and `HELP`

If you do not want to specify the `TITLE`, use the `$` symbol to indicate that you don't want to define that field.

To update a Questionnaire:

	questionnaire update TITLE HELP LANGUAGE_CODE
	
To list all questionnaires:

	questionnaire list LANGUAGE_CODE
	
To delete a questionnaire
	
	questionnaire delete QUESTIONNAIRE_CODE	
	
Where:
 - `QUESTIONNAIRE_CODE` is the questionnaire code found on DB	
 
  <a href="https://gitea.io/">
    <img alt="Gitea" src="https://raw.githubusercontent.com/go-gitea/gitea/main/public/img/gitea.svg" width="220"/>
  </a>