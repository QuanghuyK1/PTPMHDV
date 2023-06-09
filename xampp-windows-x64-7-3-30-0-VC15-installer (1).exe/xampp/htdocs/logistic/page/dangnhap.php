<div class="d-md-block d-none">
	<div class="row bg-login">
		<div class="col-lg-12 d-flex flex-column" style="margin-top: 8%">
			<div class="d-flex margin-login" style="margin-left: 30%;">
				<div class="login-select login-active me-1"><i class="fa-solid fa-phone me-2"></i>Số điện thoại</div>
				<div class="login-select"><i class="fa-solid fa-envelope me-2"></i>Email</div>
			</div>
			<div class="login-page d-flex" style="background-color:#fff;">
				<img src="/logistic/public/demo/login-img.jpg" class="w-50">
				<div class="ant-tabs ant-tabs-top ps-3">
				  <div role="tablist" class="ant-tabs-nav">
				    <div class="ant-tabs-nav-operations ant-tabs-nav-operations-hidden">
				      <button type="button" class="ant-tabs-nav-more" tabindex="-1" aria-hidden="true" aria-haspopup="listbox" aria-controls="rc-tabs-0-more-popup" id="rc-tabs-0-more" aria-expanded="false" style="visibility: hidden; order: 1;">
				        <span role="img" aria-label="ellipsis" class="anticon anticon-ellipsis">
				          <svg viewBox="64 64 896 896" focusable="false" data-icon="ellipsis" width="1em" height="1em" fill="currentColor" aria-hidden="true">
				            <path d="M176 511a56 56 0 10112 0 56 56 0 10-112 0zm280 0a56 56 0 10112 0 56 56 0 10-112 0zm280 0a56 56 0 10112 0 56 56 0 10-112 0z"></path>
				          </svg>
				        </span>
				      </button>
				    </div>
				  </div>
				  <div class="ant-tabs-content-holder">
				    <div class="ant-tabs-content ant-tabs-content-top">
				      <div id="rc-tabs-0-panel-2" role="tabpanel" tabindex="0" aria-labelledby="rc-tabs-0-tab-2" aria-hidden="false" class="ant-tabs-tabpane ant-tabs-tabpane-active">
				          <div class="ant-row">
				            <div class="ant-col">
				              <form id="form-login" class="ant-form ant-form-horizontal form-login">
				                <div class="ant-form-item mb-4">
				                  <div class="ant-row ant-form-item-row">
				                    <div class="ant-col ant-col-16 ant-form-item-control">
				                      <div class="ant-form-item-control-input">
				                        <div class="ant-form-item-control-input-content">
				                          <span class="ant-input-affix-wrapper input-login">
				                            <span class="ant-input-prefix">
				                              <span role="img" aria-label="user" class="anticon anticon-user">
				                                <svg viewBox="64 64 896 896" focusable="false" data-icon="user" width="1em" height="1em" fill="currentColor" aria-hidden="true">
				                                  <path d="M858.5 763.6a374 374 0 00-80.6-119.5 375.63 375.63 0 00-119.5-80.6c-.4-.2-.8-.3-1.2-.5C719.5 518 760 444.7 760 362c0-137-111-248-248-248S264 225 264 362c0 82.7 40.5 156 102.8 201.1-.4.2-.8.3-1.2.5-44.8 18.9-85 46-119.5 80.6a375.63 375.63 0 00-80.6 119.5A371.7 371.7 0 00136 901.8a8 8 0 008 8.2h60c4.4 0 7.9-3.5 8-7.8 2-77.2 33-149.5 87.8-204.3 56.7-56.7 132-87.9 212.2-87.9s155.5 31.2 212.2 87.9C779 752.7 810 825 812 902.2c.1 4.4 3.6 7.8 8 7.8h60a8 8 0 008-8.2c-1-47.8-10.9-94.3-29.5-138.2zM512 534c-45.9 0-89.1-17.9-121.6-50.4S340 407.9 340 362c0-45.9 17.9-89.1 50.4-121.6S466.1 190 512 190s89.1 17.9 121.6 50.4S684 316.1 684 362c0 45.9-17.9 89.1-50.4 121.6S557.9 534 512 534z"></path>
				                                </svg>
				                              </span>
				                            </span>
				                            <input autocomplete="off" id="login_username" data-testid="username" placeholder="Số điện thoại" aria-required="true" class="ant-input" type="text" value="">
				                            <!-- input dang nhap bang email -->
				                            <!-- <input autocomplete="off" id="login_username" data-testid="username" placeholder="Email" aria-required="true" class="ant-input" type="text" value="" style="display: none;"> -->
				                          </span>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				                <div class="ant-form-item">
				                  <div class="ant-row ant-form-item-row">
				                    <div class="ant-col ant-col-16 ant-form-item-control">
				                      <div class="ant-form-item-control-input">
				                        <div class="ant-form-item-control-input-content">
				                          <span class="ant-input-affix-wrapper ant-input-password input-login pass" style="height: 40px;">
				                            <span class="ant-input-prefix py-1">
				                              <span role="img" aria-label="lock" class="anticon anticon-lock site-form-item-icon">
				                                <svg viewBox="64 64 896 896" focusable="false" data-icon="lock" width="1em" height="1em" fill="currentColor" aria-hidden="true">
				                                  <path d="M832 464h-68V240c0-70.7-57.3-128-128-128H388c-70.7 0-128 57.3-128 128v224h-68c-17.7 0-32 14.3-32 32v384c0 17.7 14.3 32 32 32h640c17.7 0 32-14.3 32-32V496c0-17.7-14.3-32-32-32zM332 240c0-30.9 25.1-56 56-56h248c30.9 0 56 25.1 56 56v224H332V240zm460 600H232V536h560v304zM484 701v53c0 4.4 3.6 8 8 8h40c4.4 0 8-3.6 8-8v-53a48.01 48.01 0 10-56 0z"></path>
				                                </svg>
				                              </span>
				                            </span>
				                            <input autocomplete="off" id="login_password" data-testid="password" placeholder="Nhập mật khẩu" aria-required="true" type="password" class="ant-input">
				                            <span class="ant-input-suffix">
				                              <span role="img" aria-label="eye-invisible" tabindex="-1" class="anticon anticon-eye-invisible ant-input-password-icon">
				                                <svg viewBox="64 64 896 896" focusable="false" data-icon="eye-invisible" width="1em" height="1em" fill="currentColor" aria-hidden="true" class="pt-1">
				                                  <path d="M942.2 486.2Q889.47 375.11 816.7 305l-50.88 50.88C807.31 395.53 843.45 447.4 874.7 512 791.5 684.2 673.4 766 512 766q-72.67 0-133.87-22.38L323 798.75Q408 838 512 838q288.3 0 430.2-300.3a60.29 60.29 0 000-51.5zm-63.57-320.64L836 122.88a8 8 0 00-11.32 0L715.31 232.2Q624.86 186 512 186q-288.3 0-430.2 300.3a60.3 60.3 0 000 51.5q56.69 119.4 136.5 191.41L112.48 835a8 8 0 000 11.31L155.17 889a8 8 0 0011.31 0l712.15-712.12a8 8 0 000-11.32zM149.3 512C232.6 339.8 350.7 258 512 258c54.54 0 104.13 9.36 149.12 28.39l-70.3 70.3a176 176 0 00-238.13 238.13l-83.42 83.42C223.1 637.49 183.3 582.28 149.3 512zm246.7 0a112.11 112.11 0 01146.2-106.69L401.31 546.2A112 112 0 01396 512z"></path>
				                                  <path d="M508 624c-3.46 0-6.87-.16-10.25-.47l-52.82 52.82a176.09 176.09 0 00227.42-227.42l-52.82 52.82c.31 3.38.47 6.79.47 10.25a111.94 111.94 0 01-112 112z"></path>
				                                </svg>
				                              </span>
				                            </span>
				                          </span>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				                <div style="text-align: right; margin-bottom: 5px; margin-top: 0; color: rgb(0, 153, 255); font-weight: 500;">
				                  <a class="forgot-password">Quên mật khẩu?</a>
				                </div>
				                <div>
				                  <div class="ant-form-item">
				                    <div class="ant-row ant-form-item-row">
				                      <div class="ant-col ant-col-16 ant-form-item-control">
				                        <div class="ant-form-item-control-input">
				                          <div class="ant-form-item-control-input-content">
				                            <button id="login_submit" data-testid="signInButton" type="submit" class="ant-btn ant-btn-default btn">
				                              <span>ĐĂNG NHẬP</span>
				                            </button>
				                          </div>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				                <hr>
				                <div style="text-align: center; margin-top: 5px; margin-bottom: 10px;">
				                  <span>Bạn chưa có tài khoản?</span>
				                </div>
				                <div class="ant-form-item">
				                  <div class="ant-row ant-form-item-row">
				                    <div class="ant-col ant-col-16 ant-form-item-control">
				                      <div class="ant-form-item-control-input">
				                        <div class="ant-form-item-control-input-content">
				                          <button id="login_signup" data-testid="signUpButton" type="button" class="ant-btn ant-btn-default btn" style="background: black; color: rgb(253, 216, 0);">
				                            <span>TẠO TÀI KHOẢN</span>
				                          </button>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				              </form>
				            </div>
				          </div>
				        </div>
				      </div>
				    </div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="d-md-none d-lg-none d-sm-block">
	<div class="row bg-login">
		<div class="col-12 d-flex flex-column mt-5">
			<div class="d-flex margin-login">
				<div class="login-select login-active me-1"><i class="fa-solid fa-phone me-2"></i>Số điện thoại</div>
				<div class="login-select"><i class="fa-solid fa-envelope me-2"></i>Email</div>
			</div>
			<div class="login-page mx-0 w-100 d-flex" style="background-color:#fff;">
				<img src="/logistic/public/demo/login-img.jpg" class="w-50">
				<div class="ant-tabs ant-tabs-top ps-3">
				  <div role="tablist" class="ant-tabs-nav">
				    <div class="ant-tabs-nav-operations ant-tabs-nav-operations-hidden">
				      <button type="button" class="ant-tabs-nav-more" tabindex="-1" aria-hidden="true" aria-haspopup="listbox" aria-controls="rc-tabs-0-more-popup" id="rc-tabs-0-more" aria-expanded="false" style="visibility: hidden; order: 1;">
				        <span role="img" aria-label="ellipsis" class="anticon anticon-ellipsis">
				          <svg viewBox="64 64 896 896" focusable="false" data-icon="ellipsis" width="1em" height="1em" fill="currentColor" aria-hidden="true">
				            <path d="M176 511a56 56 0 10112 0 56 56 0 10-112 0zm280 0a56 56 0 10112 0 56 56 0 10-112 0zm280 0a56 56 0 10112 0 56 56 0 10-112 0z"></path>
				          </svg>
				        </span>
				      </button>
				    </div>
				  </div>
				  <div class="ant-tabs-content-holder">
				    <div class="ant-tabs-content ant-tabs-content-top">
				      <div id="rc-tabs-0-panel-2" role="tabpanel" tabindex="0" aria-labelledby="rc-tabs-0-tab-2" aria-hidden="false" class="ant-tabs-tabpane ant-tabs-tabpane-active">
				          <div class="ant-row">
				            <div class="ant-col">
				              <form id="form-login" class="ant-form ant-form-horizontal form-login">
				                <div class="ant-form-item mb-4">
				                  <div class="ant-row ant-form-item-row">
				                    <div class="ant-col ant-col-16 ant-form-item-control">
				                      <div class="ant-form-item-control-input">
				                        <div class="ant-form-item-control-input-content">
				                          <span class="ant-input-affix-wrapper input-login">
				                            <span class="ant-input-prefix">
				                              <span role="img" aria-label="user" class="anticon anticon-user">
				                                <svg viewBox="64 64 896 896" focusable="false" data-icon="user" width="1em" height="1em" fill="currentColor" aria-hidden="true">
				                                  <path d="M858.5 763.6a374 374 0 00-80.6-119.5 375.63 375.63 0 00-119.5-80.6c-.4-.2-.8-.3-1.2-.5C719.5 518 760 444.7 760 362c0-137-111-248-248-248S264 225 264 362c0 82.7 40.5 156 102.8 201.1-.4.2-.8.3-1.2.5-44.8 18.9-85 46-119.5 80.6a375.63 375.63 0 00-80.6 119.5A371.7 371.7 0 00136 901.8a8 8 0 008 8.2h60c4.4 0 7.9-3.5 8-7.8 2-77.2 33-149.5 87.8-204.3 56.7-56.7 132-87.9 212.2-87.9s155.5 31.2 212.2 87.9C779 752.7 810 825 812 902.2c.1 4.4 3.6 7.8 8 7.8h60a8 8 0 008-8.2c-1-47.8-10.9-94.3-29.5-138.2zM512 534c-45.9 0-89.1-17.9-121.6-50.4S340 407.9 340 362c0-45.9 17.9-89.1 50.4-121.6S466.1 190 512 190s89.1 17.9 121.6 50.4S684 316.1 684 362c0 45.9-17.9 89.1-50.4 121.6S557.9 534 512 534z"></path>
				                                </svg>
				                              </span>
				                            </span>
				                            <input autocomplete="off" id="login_username" data-testid="username" placeholder="Số điện thoại" aria-required="true" class="ant-input" type="text" value="">
				                            <!-- input dang nhap bang email -->
				                            <!-- <input autocomplete="off" id="login_username" data-testid="username" placeholder="Email" aria-required="true" class="ant-input" type="text" value="" style="display: none;"> -->
				                          </span>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				                <div class="ant-form-item">
				                  <div class="ant-row ant-form-item-row">
				                    <div class="ant-col ant-col-16 ant-form-item-control">
				                      <div class="ant-form-item-control-input">
				                        <div class="ant-form-item-control-input-content">
				                          <span class="ant-input-affix-wrapper ant-input-password input-login pass" style="height: 40px;">
				                            <span class="ant-input-prefix py-1">
				                              <span role="img" aria-label="lock" class="anticon anticon-lock site-form-item-icon">
				                                <svg viewBox="64 64 896 896" focusable="false" data-icon="lock" width="1em" height="1em" fill="currentColor" aria-hidden="true">
				                                  <path d="M832 464h-68V240c0-70.7-57.3-128-128-128H388c-70.7 0-128 57.3-128 128v224h-68c-17.7 0-32 14.3-32 32v384c0 17.7 14.3 32 32 32h640c17.7 0 32-14.3 32-32V496c0-17.7-14.3-32-32-32zM332 240c0-30.9 25.1-56 56-56h248c30.9 0 56 25.1 56 56v224H332V240zm460 600H232V536h560v304zM484 701v53c0 4.4 3.6 8 8 8h40c4.4 0 8-3.6 8-8v-53a48.01 48.01 0 10-56 0z"></path>
				                                </svg>
				                              </span>
				                            </span>
				                            <input autocomplete="off" id="login_password" data-testid="password" placeholder="Nhập mật khẩu" aria-required="true" type="password" class="ant-input">
				                            <span class="ant-input-suffix">
				                              <span role="img" aria-label="eye-invisible" tabindex="-1" class="anticon anticon-eye-invisible ant-input-password-icon">
				                                <svg viewBox="64 64 896 896" focusable="false" data-icon="eye-invisible" width="1em" height="1em" fill="currentColor" aria-hidden="true" class="pt-1">
				                                  <path d="M942.2 486.2Q889.47 375.11 816.7 305l-50.88 50.88C807.31 395.53 843.45 447.4 874.7 512 791.5 684.2 673.4 766 512 766q-72.67 0-133.87-22.38L323 798.75Q408 838 512 838q288.3 0 430.2-300.3a60.29 60.29 0 000-51.5zm-63.57-320.64L836 122.88a8 8 0 00-11.32 0L715.31 232.2Q624.86 186 512 186q-288.3 0-430.2 300.3a60.3 60.3 0 000 51.5q56.69 119.4 136.5 191.41L112.48 835a8 8 0 000 11.31L155.17 889a8 8 0 0011.31 0l712.15-712.12a8 8 0 000-11.32zM149.3 512C232.6 339.8 350.7 258 512 258c54.54 0 104.13 9.36 149.12 28.39l-70.3 70.3a176 176 0 00-238.13 238.13l-83.42 83.42C223.1 637.49 183.3 582.28 149.3 512zm246.7 0a112.11 112.11 0 01146.2-106.69L401.31 546.2A112 112 0 01396 512z"></path>
				                                  <path d="M508 624c-3.46 0-6.87-.16-10.25-.47l-52.82 52.82a176.09 176.09 0 00227.42-227.42l-52.82 52.82c.31 3.38.47 6.79.47 10.25a111.94 111.94 0 01-112 112z"></path>
				                                </svg>
				                              </span>
				                            </span>
				                          </span>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				                <div style="text-align: right; margin-bottom: 5px; margin-top: 0; color: rgb(0, 153, 255); font-weight: 500;">
				                  <a class="forgot-password">Quên mật khẩu?</a>
				                </div>
				                <div>
				                  <div class="ant-form-item">
				                    <div class="ant-row ant-form-item-row">
				                      <div class="ant-col ant-col-16 ant-form-item-control">
				                        <div class="ant-form-item-control-input">
				                          <div class="ant-form-item-control-input-content">
				                            <button id="login_submit" data-testid="signInButton" type="submit" class="ant-btn ant-btn-default btn">
				                              <span>ĐĂNG NHẬP</span>
				                            </button>
				                          </div>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				                <hr>
				                <div style="text-align: center; margin-top: 5px; margin-bottom: 10px;">
				                  <span>Bạn chưa có tài khoản?</span>
				                </div>
				                <div class="ant-form-item">
				                  <div class="ant-row ant-form-item-row">
				                    <div class="ant-col ant-col-16 ant-form-item-control">
				                      <div class="ant-form-item-control-input">
				                        <div class="ant-form-item-control-input-content">
				                          <button id="login_signup" data-testid="signUpButton" type="button" class="ant-btn ant-btn-default btn" style="background: black; color: rgb(253, 216, 0);">
				                            <span>TẠO TÀI KHOẢN</span>
				                          </button>
				                        </div>
				                      </div>
				                    </div>
				                  </div>
				                </div>
				              </form>
				            </div>
				          </div>
				        </div>
				      </div>
				    </div>
				</div>
			</div>
		</div>
	</div>
</div>