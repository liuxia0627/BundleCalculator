# Bundle Calculator
This project is to implement the bundle calculator used by social media influencers in the following scenario:
- Social media influencers decided to sell posts in bundle and charges will be calculated on a per bundle basis. 
- SubmissionFormats.txt file which contains format, format code and budnles info of pre-defined submission formats is provided by social media influencers, and it follows the below formate:

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450; 10 @ $800
Audio | Flac | 3 @ $427.50; 6 @ $810; 9 @ $1147.50
Video | VID | 3 @ $570; 5 @ $900; 9 @ $1530
- Orders.txt contains amount and format code info of the order, and it follows the below format:
```
10 IMG
15 FLAC
13 VID
```
- Outputs.txt contains the info of the output and it has the cost and bundle breakdown for each format order which is produced by the bundle calculator.Following is a sample outputs of the above testing orders:
```
10 IMG $800.0
 1 x 10 $800.0

15 FLAC $1957.5
 1 x 9 $1147.5
 1 x 6 $810.0

13 VID $2370.0
 2 x 5 $1800.0
 1 x 3 $570.0
```

# Useage
Define the Orders.txt and run BundleCalculatorDemo.java, and you will get outputs in the Outputs.txt
