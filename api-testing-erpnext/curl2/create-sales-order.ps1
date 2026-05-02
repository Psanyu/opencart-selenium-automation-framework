curl.exe -X POST "http://localhost:8000/api/resource/Sales%20Order" `
-H "Content-Type: application/json" `
-b cookies.txt `
--data-binary "@../payloads/salesorder.json"
