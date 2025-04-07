function fn() {
  let BaseUrl = Java.type('com.common.utils.core.enums.BaseUrl');
  let Product = Java.type('com.common.utils.core.enums.Product$name');
  karate.log('Product: ' + Product);  // Check if Product is properly loaded

  // Pick product based on env or hardcoded for now
  let sourceDemo = Product.SELENIUM;
  let automationPractice = Product.AUTOMATION_PRACTICE;

  return {
    sauceDemoUrlUI: BaseUrl.UI.getUrl(sourceDemo),
    automationPracticeUrlAPI: BaseUrl.API.getUrl(automationPractice)
  };
}