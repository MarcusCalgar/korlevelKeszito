# korlevelKeszito / circular letter creator

## Summary
An application that uses the console to create a circular letter, customize it, and "send" it to various recipients. Actually, it saves the letters into text files. This project was part of the StudiCore Online curriculum.

<b>Note</b>: classes, variables and methods are in Hungarian. 

## What does it do?

1. The program uses the standard console input to ask for a filename, that contains the template of the email that we want to send to multiple recipients.
If it finds the file, it loads its contents. If not, it notifies the user via an error message in the console, and quits.
2. Next, it asks for the csv file that contains the recipients.
3. Then, it asks for a template that it uses to name the files. The template has to be in the format of <i>####.\<extension\></i>, for example: <i>####.txt</i>.
In this case, the files will be named 0001.txt, 0002.txt...etc.
  
<a href="https://imgur.com/n1p9DaF"><img src="https://i.imgur.com/n1p9DaF.png" title="korlevel_input" /></a>

Then the program automatically creates the letters and saves them to text files in this example.

## How does it work?

1. The program starts, and asks for the template of the letter we want to send. It reads it line by line and saves it to its `sablon` data member in a `Sablon.java` class.
2. Then it asks for the `csv` file that contains the recipients and creates a `LevelAdatOlvaso.java` class. It initializes the `BufferedReader buffer` data member with the provided filename.
3. Then it asks for the template for the filenames. This contains a number of `#` signs, and an extension. However, if the number of generated letters surpass the maximum number the filename template can support, the creating of the files will fail.
4. The program maps the fields of the `csv` file, and switches the appropriate fields in the letter template provided.
5. It generates the letter, assigns a new filename, and writes/creates the letter.
6. It continues until the recipient list in the `csv` file is exhausted.
7. The program quits.
