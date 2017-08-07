# mobile-tests-project
1. <h3>checkDeleteListTest:</h3> 
Checking the possibility of deleting a list
 - input name of new list
 - input name of first product
 - select category
 - save product and back to page with list
 - delete created list
 - confirm deletion dialog 
 - **check that list is empty**
 
 2. <h3>checkFullFieldsInItem:</h3> 
Check for correct display of all filled fields
 - input name of new list
 - input name of first product
 - select category
 - set amount
 - set price
 - select measure
 - save product
 - **check that all field is diplayed and saved**
 
 3. <h3>checkTotalPrice:</h3> 
Check for correct count of total price
 - input name of new list
 - input name of first product
 - set amount for first product
 - set price for first product
 - save field for first product
 - input name for second product
 - set price and amount for second product
 - save product
 - **check summing prices of both product is correct display**
 
 4. <h3>checkEditList:</h3> 
Checking the possibility of editing name of list
 - input name of new list
 - input name of first product
 - save product and back to page with lists
 - click to edit list and change name
 - **check that new name is saved**
 
 5. <h3>checkSortingList:</h3> 
Checking sorting lists on the page
 - input three names of lists
 - **check that order lists is correct (in the addition sequence)**
 
 6. <h3>checkChangeCurrency:</h3> 
Checking correct display new currency
 - open settings
 - select currency with $
 - back to lisis page
 - add new list
 - input new product item
 - set price
 - save products
 - **check that currency of price displaye like $**
 
  6. <h3>checkNotDisplayedPriceAndCommentBeforeCreating:</h3> 
Check that price and comment don't display after sett off in settings (before creating new item)
 - open settings
 - unchecked posibility displaying comment and price
 - back to lisis page
 - add new list
 - input new product item
 - set price
 - set comment
 - save products
 - **check that settings is work and comment with prie doesn't display**
 
  7. <h3>checkNotDisplayedPriceAndCommentAfterCreating:</h3> 
Check that price and comment don't display after sett off in settings (after creating new item)
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
 
 
  8. <h3>addNewItemsToList:</h3> 
Checking displayed creted items and lists
 - add new list
 - input new product item
 - save product and back to my list pagw
 - add new one list with new product
 - backto my lists page
 - open first list and check that first item is displayed
 - back to list page
 - **check that two list are displayed**
 
  9. <h3>checkAlphabeticSortingItems:</h3> 
Check alphabetic sorting items in list
 - add new list
 - input five products
 - check that sorting products are in the addition sequence
 - open setting
 - select sorting list like "By alphabet"
 - open list
 - **check that all product display in alphabet order**
