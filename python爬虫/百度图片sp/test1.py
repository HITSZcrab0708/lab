from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
import re


browser=webdriver.Safari()
browser.get("http://www.sebobox9.com/photo")
browser.implicitly_wait(10)
print(browser.page_source)
html=browser.page_source
pic_url = re.findall('<img src="https://i.bdcache.com/pp1/250/71/71a8883ff28dfa2e9be6a7a2cfe1a927ad69946f.jpg"',html,re.S)
print(pic_url)

browser.close()


