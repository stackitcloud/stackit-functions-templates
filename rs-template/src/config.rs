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

use actix_web::web::{Data, ServiceConfig};
use log::info;

/// Run custom configuration as part of the application building
/// process.
///
/// This function should contain all custom configuration for your function application.
///
/// ```rust
/// fn configure(cfg: &mut ServiceConfig) {
///     let db_driver = my_db();
///     cfg.data(db_driver.clone());
/// }
/// ```
///
/// Then you can use configured resources in your function.
///
/// ```rust
/// pub async fn index(
///     req: HttpRequest,
///     driver: Data<DbDriver>,
/// ) -> HttpResponse {
///     HttpResponse::NoContent()
/// }
pub fn configure(cfg: &mut ServiceConfig) {
    info!("Configuring service");
    cfg.app_data(Data::new(HandlerConfig::default()));
}

/// An example of the function configuration structure.
#[derive(Clone)]
pub struct HandlerConfig {
    pub name: String,
}

impl Default for HandlerConfig {
    fn default() -> HandlerConfig {
        HandlerConfig {
            name: "world".into(),
        }
    }
}
