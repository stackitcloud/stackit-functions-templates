/**
 * Copyright 2026 Schwarz Digits Cloud GmbH & Co. KG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

type FnContext = {
  method?: string;
  path?: string;
  query?: Record<string, string>;
  headers?: Record<string, unknown>;
  cloudevent?: any;
  log?: { info: (...a: any[]) => void; error: (...a: any[]) => void };
  cloudEventResponse?: (data: any) => any;
};

type FnInstance = {
  init?: () => void | Promise<void>;
  shutdown?: () => void | Promise<void>;
  handle: (ctx: FnContext, data: any) => any;
};

function newFn(): FnInstance {
  return {
    handle: async (ctx, _data) => {
      const m = ctx.method || "GET";
      const p = ctx.path || "/";

      ctx.log?.info?.({ msg: "fn_handle", method: m, path: p });

      if (m === "GET" && p === "/") {
        return { statusCode: 200, body: "Hello from STACKIT Functions" };
      }

      return {
        statusCode: 404,
        body: { error: "not_found", method: m, path: p },
      };
    },
  };
}

// Contract: wrapper expects either export object with .new() or instance
export = { new: newFn };
