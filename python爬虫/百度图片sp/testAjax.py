
import re
import urllib.error
import urllib.request
import ssl
import os
import  requests

ssl._create_default_https_context = ssl._create_unverified_context #跳过证书验证
path='/Users/macbookpro/Desktop'
headers = {
    "Cookie": "ttwid=1%7CJW2J4VECatAK0uP7C4yDhIF2tR7CYp1KG0X-IaU3FIk%7C1630380199%7C681f6f46b0a640ac831cd64552925666088ec757b932bd19c6410fa5ccde7ce1; MONITOR_WEB_ID=7002133481635841549; _S_DPR=2; _S_IPAD=0; _S_WIN_WH=1208_634; tt_webid=7002133460107511333",
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.1 Safari/605.1.15"
}#用cookie获取到正确的网页源代码
url="https://so.toutiao.com/search?keyword=%E8%A1%97%E6%8B%8D&pd=atlas&dvpf=pc&aid=4916&page_num=2&search_json=%7B%22from_search_id%22%3A%22202108311449520101501320965956DC4B%22%2C%22origin_keyword%22%3A%22%E8%A1%97%E6%8B%8D%22%2C%22image_keyword%22%3A%22%E8%A1%97%E6%8B%8D%22%7D&rawJSON=1&search_id=202108311453390102121921512A38625D"
req=urllib.request.Request(url=url,headers=headers)
html=""
try:
        response=urllib.request.urlopen(req)
        html=response.read().decode('utf-8')
except urllib.error.URLError as e:
        if hasattr(e,"code"):
            print(e.code)
        if hasattr(e,"reason"):
            print(e.reason)
print(html)
pic_url = re.findall('"img_url":"(.*?)",', html, re.S)
# if not os.path.exists('图片'):
#     os.mkdir('图片')
# i=1
# for item in pic_url:
#     try:
#         res=requests.get(item)
#         if res.status_code == 200:
#             file_path='{0}/{1}.{2}'.format('图片',i,'jpg')
#             if not os.path.exists(file_path):
#                 with open(file_path,'wb') as f:
#                     f.write(res.content)
#             else:
#                 print('already downloaded',file_path)
#     except requests.ConnectionError:
#         print('fail to save image')
#     i+=1
print(pic_url)











