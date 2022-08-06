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

## Command line
Q-Manager can be used from the command line. The commands are the followings:

## Running

To make the executable jar file:

	mvn clean package
	
To run the application:
	
	java -jar q-manager.jar
	
#### Create a Questionnaire
To create a questionnaire:

	questionnaire create TITLE HELP LANGUAGE_CODE

Where:
 - `TITLE` is the title of your questionnaire
 - `HELP` is the text that describes the questionnaire
 - `LANGUAGE_CODE` the language code of the `TITLE` and `HELP`

If you do not want to specify the `TITLE`, use the `$` symbol to indicate that you don't want to define that field.

To update a questionnaire:

	questionnaire update TITLE HELP LANGUAGE_CODE
	
To list all questionnaires:

	questionnaire list LANGUAGE_CODE
	
To delete a questionnaire
	
	questionnaire delete QUESTIONNAIRE_CODE	
	
Where:
 - `QUESTIONNAIRE_CODE` is the questionnaire code found on DB	
 
#### Create a Group
To create a group:

	group create TITLE HELP LANGUAGE_CODE

Where:
 - `TITLE` is the title of your group
 - `HELP` is the text that describes the group
 - `LANGUAGE_CODE` the language code of the `TITLE` and `HELP`

If you do not want to specify the `TITLE`, use the `$` symbol to indicate that you don't want to define that field.

To update a group:

	group update TITLE HELP LANGUAGE_CODE
	
To list all groups:

	group list LANGUAGE_CODE
	
To delete a group
	
	group delete GROUP_CODE	
	
Where:
 - `GROUP_CODE` is the group code found on DB	 
 
#### Create a Section
To create a section:

	section create TITLE HELP LANGUAGE_CODE

Where:
 - `TITLE` is the title of your section
 - `HELP` is the text that describes the section
 - `LANGUAGE_CODE` the language code of the `TITLE` and `HELP`

If you do not want to specify the `TITLE`, use the `$` symbol to indicate that you don't want to define that field.

To update a section:

	section update TITLE HELP LANGUAGE_CODE
	
To list all sections:

	section list LANGUAGE_CODE
	
To delete a section
	
	section delete SECTION_CODE	
	
Where:
 - `SECTION_CODE` is the section code found on DB	  

## Here is the DB schema:

<img alt="Q-Manager Schema" src="http://192.168.1.101:3000/gitea/questionnaire-manager-core/raw/branch/master/questionnaire-manager-schema.png" />
