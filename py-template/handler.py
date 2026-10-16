# Copyright 2026 Schwarz Digits Cloud GmbH & Co. KG
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import json
from typing import Any, Dict, Optional


def new():
    return Function()

class Function:
    # Optional lifecycle hooks
    async def start(self):
        # init resources, warm caches, open pools, etc.
        return

    async def stop(self):
        # cleanup
        return


    # Implement your function here
    async def handle(self, scope, receive, send):
        assert scope["type"] == "http"
        method = scope.get("method", "GET")
        path = scope.get("path", "/")

        # ---  routing ---
        if method == "GET" and path == "/":

            await send({"type": "http.response.start", "status": 200, "headers": dict()})
            return await send({"type": "http.response.body", "body": "Hello from STACKIT Functions".encode("utf-8")})

        # ---  default ---
        await send({"type": "http.response.start", "status": 404, "headers": dict()})
        return await send({"type": "http.response.body", "body": "not_found".encode("utf-8")})
