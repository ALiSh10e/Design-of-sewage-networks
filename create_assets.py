import os

html_content = r'''<!doctype html>
<html lang="ar" dir="rtl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>HydroFlow Pro - Sewer Network Analyzer</title>
  </head>
  <body class="bg-[#0F172A]">
    <div id="root"></div>
    <script src="./bundle.js"></script>
  </body>
</html>
'''

os.makedirs('/app/src/main/assets', exist_ok=True)
with open('/app/src/main/assets/index.html', 'w', encoding='utf-8') as f:
    f.write(html_content)

print("index.html created successfully")
