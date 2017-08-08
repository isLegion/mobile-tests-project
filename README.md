# mobile-tests-project

## Instruction for run:

1. Setup configuration for device and app in file **ApplicationConfig.properties**
2. Setup APPIUM_BINARY_PATH in environmental variable for appium server running.
(e.g. APPIUM_BINARY_PATH=C:\Users\YourUserName\AppData\Roaming\npm\node_modules\appium\build\lib\main.js or
/Users/yourname/node_modules/appium/lib/appium.js)
3. Run your simulator
4. Run tests in MainTest.class
5. Enjoy!

With test cases you can read below

## Test cases:
#### 1. checkDeleteListTest: Checking the possibility of deleting a list
 - input name of new list
 - input name of first product
 - select category
 - save product and back to page with list
 - delete created list
 - confirm deletion dialog 
 - **check that list is empty**
 
#### 2. checkFullFieldsInItem: Check for correct display of all filled fields
 - input name of new list
 - input name of first product
 - select category
 - set amount
 - set price
 - select measure
 - save product
 - **check that all field is diplayed and saved**
 
#### 3. checkTotalPrice: Check for correct count of total price
 - input name of new list
 - input name of first product
 - set amount for first product
 - set price for first product
 - save field for first product
 - input name for second product
 - set price and amount for second product
 - save product
 - **check summing prices of both product is correct display**
 
#### 4. checkEditList: Checking the possibility of editing name of list
 - input name of new list
 - input name of first product
 - save product and back to page with lists
 - click to edit list and change name
 - **check that new name is saved**
 
#### 5. checkSortingList: Checking sorting lists on the page
 - input three names of lists
 - **check that order lists is correct (in the addition sequence)**

#### 6. checkChangeCurrency: Checking correct display new currency
 - open settings
 - select currency with $
 - back to lisis page
 - add new list
 - input new product item
 - set price
 - save products
 - **check that currency of price displaye like $**

#### 7. checkNotDisplayedPriceAndCommentBeforeCreating: Check that price and comment don't display after sett off in settings (before creating new item)
 - open settings
 - unchecked posibility displaying comment and price
 - back to lisis page
 - add new list
 - input new product item
 - set price
 - set comment
 - save products
 - **check that settings is work and comment with prie doesn't display**
 
#### 8. checkNotDisplayedPriceAndCommentAfterCreating: Check that price and comment don't display after sett off in settings (after creating new item)
 - add new list
 - input new product item
 - set price
 - set comment
 - save products
 - check that comment and price are displayed
 - open settings
 - unchecked posibility displaying comment and price
 - back to lisis page
 - **check that settings is work and comment with prie doesn't display**
 
#### 9. addNewItemsToList: Checking displayed creted items and lists
 - add new list
 - input new product item
 - save product and back to my list pagw
 - add new one list with new product
 - backto my lists page
 - open first list and check that first item is displayed
 - back to list page
 - **check that two list are displayed**

#### 10. checkAlphabeticSortingItems: Check alphabetic sorting items in list
 - add new list
 - input five products
 - check that sorting products are in the addition sequence
 - open setting
 - select sorting list like "By alphabet"
 - open list
 - **check that all product display in alphabet order**
