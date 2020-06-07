package seleniumMethods;

public class XpathAndLocators {

	// -we have different type of locators the most used are : 1-id, 2-class,
	// 3-className, 4-CSS(10 time faster than xpath), 5-Xpath.

	// *** XPATH: we have Absolute xpath and Relative xpath

	// **A-Absolute xpath: we use single slash '/'
	// this type of xpath is so long and if there is any change in html nodes
	// (codes) the Absolute xpath is not good any more

	// **B-Relative xpath (we create them): we use double slash '//'
	// those type of xpath are short more efficient, also we can use sibling.

	// B1- xpath created with tag name and attribute name ex:
	// //tagName[@attributeName ='value']
	// we can also use and to add an attributeName //tagName[@attributeName
	// ='value'and @attributeName ='value']
	// B2- xpath created with text and its value ex: //tagName[text()='text value']

	// B3- xpath created using contains ex: //tagName[contains(text(),'text value')]
	// tagName[contains(@attributeName ,'value']

	// ******* parent to child & child to parent:
	// -1 parent to child:
	// grand parent parent child
	// ex1: //tagName[contains(text(),'text value')]/tagName/tagName
	// ex2: //tagName[contains(text(),'text value')]//tagName[contains(text(),'text
	// value')]
	// parent child
	// -2 child to parent:

	// tagName[contains(text(),'text value')]/parent::/tagName/parent::/tagName
	// child                                parent            grandParent

	// ************************ SIBLING ********************
	// - webElement to its neighbor:
	// A-Following:
	// Ex: //tagName[contains(text(),'text value')]/following-sibling::/tagName
	// B- Preceding:
	// Ex: //tagName[contains(text(),'text value')]/preceding-sibling::/tagName

	// ***************** table Xpath:
	
	
	
	
	

	// NB: We can also use index ex: //tagName[contains(text(),'text
	// value')]/tagName[index]
	// ex2: (//tagName[contains(text(),'text value')])[index]

	// *** CSS: (no slash on CSS)

	// ex: tagName[attributeN ='value']
	// ex: tagName[attributeN *='value']
	// ex: tagName#id
	// ex: tagName.classeName

	// NB(for CSS):
	// 1- leave blank if you don't want to put tagName ex: #id or .classeName
	// 2- replace space with dot(.) in classeName
	// 3-in case of dynamic attribute use contains syntax.

}
