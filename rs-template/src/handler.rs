// Copyright 2026 Schwarz Digits Cloud GmbH & Co. KG
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

use crate::config::HandlerConfig;
use actix_web::{HttpRequest, HttpResponse, http::Method, web::Data};
use log::info;

// Implement your function's logic here
pub async fn index(req: HttpRequest, config: Data<HandlerConfig>) -> HttpResponse {
    info!("{:#?}", req);
    if req.method() == Method::GET && req.path() == "/" {
       return HttpResponse::Ok().body("Hello from STACKIT Functions");
    }

    HttpResponse::NotFound().body("not_found")
}
