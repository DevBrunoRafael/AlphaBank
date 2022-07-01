package App.Components.SendingEmails;

public abstract class MailMarketing {

    public static final String model = """      
        <!DOCTYPE html>
                    
        <html
          lang="pt-br"
          xmlns:o="urn:schemas-microsoft-com:office:office"
          xmlns:v="urn:schemas-microsoft-com:vml"
        >
          <head>
            <title></title>
            <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
            <meta content="width=device-width, initial-scale=1.0" name="viewport" />
            <!--[if mso
              ]><xml
                ><o:OfficeDocumentSettings
                  ><o:PixelsPerInch>96</o:PixelsPerInch
                  ><o:AllowPNG /></o:OfficeDocumentSettings></xml
            ><![endif]-->
            <!--[if !mso]><!-->
            <link
              href="https://fonts.googleapis.com/css?family=Cabin"
              rel="stylesheet"
              type="text/css"
            />
            <!--<![endif]-->
            <style>
              * {
                box-sizing: border-box;
              }
                    
              body {
                margin: 0;
                padding: 0;
              }
                    
              a[x-apple-data-detectors] {
                color: inherit !important;
                text-decoration: inherit !important;
              }
                    
              #MessageViewBody a {
                color: inherit;
                text-decoration: none;
              }
                    
              p {
                line-height: inherit;
              }
                    
              .desktop_hide,
              .desktop_hide table {
                mso-hide: all;
                display: none;
                max-height: 0px;
                overflow: hidden;
              }
                    
              @media (max-width: 620px) {
                .desktop_hide table.icons-inner {
                  display: inline-block !important;
                }
                    
                .icons-inner {
                  text-align: center;
                }
                    
                .icons-inner td {
                  margin: 0 auto;
                }
                    
                .image_block img.big,
                .row-content {
                  width: 100% !important;
                }
                    
                .mobile_hide {
                  display: none;
                }
                    
                .stack .column {
                  width: 100%;
                  display: block;
                }
                    
                .mobile_hide {
                  min-height: 0;
                  max-height: 0;
                  max-width: 0;
                  overflow: hidden;
                  font-size: 0px;
                }
                    
                .desktop_hide,
                .desktop_hide table {
                  display: table !important;
                  max-height: none !important;
                }
              }
            </style>
          </head>
          <body
            style="
              background-color: #ffffff;
              margin: 0;
              padding: 0;
              -webkit-text-size-adjust: none;
              text-size-adjust: none;
            "
          >
            <table
              border="0"
              cellpadding="0"
              cellspacing="0"
              class="nl-container"
              role="presentation"
              style="
                mso-table-lspace: 0pt;
                mso-table-rspace: 0pt;
                background-color: #ffffff;
              "
              width="100%"
            >
              <tbody>
                <tr>
                  <td>
                    <table
                      align="center"
                      border="0"
                      cellpadding="0"
                      cellspacing="0"
                      class="row row-1"
                      role="presentation"
                      style="mso-table-lspace: 0pt; mso-table-rspace: 0pt"
                      width="100%"
                    >
                      <tbody>
                        <tr>
                          <td>
                            <table
                              align="center"
                              border="0"
                              cellpadding="0"
                              cellspacing="0"
                              class="row-content stack"
                              role="presentation"
                              style="
                                mso-table-lspace: 0pt;
                                mso-table-rspace: 0pt;
                                background-color: #ffd500;
                                color: #000000;
                                width: 600px;
                              "
                              width="600"
                            >
                              <tbody>
                                <tr>
                                  <td
                                    class="column column-1"
                                    style="
                                      mso-table-lspace: 0pt;
                                      mso-table-rspace: 0pt;
                                      font-weight: 400;
                                      text-align: left;
                                      vertical-align: top;
                                      padding-left: 20px;
                                      padding-top: 5px;
                                      padding-bottom: 5px;
                                      border-top: 0px;
                                      border-right: 0px;
                                      border-bottom: 0px;
                                      border-left: 0px;
                                    "
                                    width="100%"
                                  >
                                    <table
                                      border="0"
                                      cellpadding="25"
                                      cellspacing="0"
                                      class="image_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td>
                                          <div style="line-height: 10px">
                                            <img
                                              alt="Image"
                                              class="big"
                                              src="images/logo.png"
                                              style="
                                                display: block;
                                                height: auto;
                                                border: 0;
                                                width: 300px;
                                                max-width: 100%;
                                              "
                                              title="Image"
                                              width="300"
                                            />
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                    <table
                      align="center"
                      border="0"
                      cellpadding="0"
                      cellspacing="0"
                      class="row row-2"
                      role="presentation"
                      style="mso-table-lspace: 0pt; mso-table-rspace: 0pt"
                      width="100%"
                    >
                      <tbody>
                        <tr>
                          <td>
                            <table
                              align="center"
                              border="0"
                              cellpadding="0"
                              cellspacing="0"
                              class="row-content stack"
                              role="presentation"
                              style="
                                mso-table-lspace: 0pt;
                                mso-table-rspace: 0pt;
                                background-color: #ffffff;
                                color: #000000;
                                width: 600px;
                              "
                              width="600"
                            >
                              <tbody>
                                <tr>
                                  <td
                                    class="column column-1"
                                    style="
                                      mso-table-lspace: 0pt;
                                      mso-table-rspace: 0pt;
                                      font-weight: 400;
                                      text-align: left;
                                      vertical-align: top;
                                      padding-left: 35px;
                                      padding-right: 35px;
                                      padding-top: 35px;
                                      padding-bottom: 40px;
                                      border-top: 0px;
                                      border-right: 0px;
                                      border-bottom: 0px;
                                      border-left: 0px;
                                    "
                                    width="100%"
                                  >
                                    <table
                                      border="0"
                                      cellpadding="10"
                                      cellspacing="0"
                                      class="text_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                        word-break: break-word;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td>
                                          <div style="font-family: sans-serif">
                                            <div
                                              class="txtTinyMce-wrapper"
                                              style="
                                                font-size: 12px;
                                                mso-line-height-alt: 14.399999999999999px;
                                                color: #132f40;
                                                line-height: 1.2;
                                                font-family: Cabin, Arial,
                                                  Helvetica Neue, Helvetica, sans-serif;
                                              "
                                            >
                                              <p
                                                style="
                                                  margin: 0;
                                                  font-size: 14px;
                                                  text-align: center;
                                                "
                                              >
                                                <strong
                                                  ><span style="font-size: 22px"
                                                    > Seu Extrato Bancário Chegou!</span
                                                  ></strong
                                                >
                                              </p>
                                            </div>
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                    <table
                                      border="0"
                                      cellpadding="0"
                                      cellspacing="0"
                                      class="text_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                        word-break: break-word;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td
                                          style="
                                            padding-bottom: 30px;
                                            padding-left: 10px;
                                            padding-right: 10px;
                                            padding-top: 5px;
                                          "
                                        >
                                          <div style="font-family: sans-serif">
                                            <div
                                              class="txtTinyMce-wrapper"
                                              style="
                                                font-size: 12px;
                                                mso-line-height-alt: 18px;
                                                color: #555555;
                                                line-height: 1.5;
                                                font-family: Cabin, Arial,
                                                  Helvetica Neue, Helvetica, sans-serif;
                                              "
                                            >
                                              <p
                                                style="
                                                  margin: 0;
                                                  font-size: 12px;
                                                  text-align: center;
                                                "
                                              >
                                                Com nosso serviço de e-mail avançado
                                                você tem o acesso a qualquer serviço na
                                                palma da mão, isso e muito mais você só
                                                encontra aqui no <em>TECH BANK.</em>
                                              </p>
                                            </div>
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                    <table
                                      border="0"
                                      cellpadding="0"
                                      cellspacing="0"
                                      class="image_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td
                                          style="
                                            width: 100%;
                                            padding-right: 0px;
                                            padding-left: 0px;
                                          "
                                        >
                                          <div align="center" style="line-height: 10px">
                                            <img
                                              alt="Image"
                                              class="big"
                                              src="images/illo.png"
                                              style="
                                                display: block;
                                                height: auto;
                                                border: 0;
                                                width: 530px;
                                                max-width: 100%;
                                              "
                                              title="Image"
                                              width="530"
                                            />
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                    <table
                                      border="0"
                                      cellpadding="0"
                                      cellspacing="0"
                                      class="text_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                        word-break: break-word;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td
                                          style="
                                            padding-bottom: 10px;
                                            padding-left: 10px;
                                            padding-right: 10px;
                                            padding-top: 20px;
                                          "
                                        >
                                          <div style="font-family: sans-serif">
                                            <div
                                              class="txtTinyMce-wrapper"
                                              style="
                                                font-size: 12px;
                                                mso-line-height-alt: 14.399999999999999px;
                                                color: #555555;
                                                line-height: 1.2;
                                                font-family: Cabin, Arial,
                                                  Helvetica Neue, Helvetica, sans-serif;
                                              "
                                            >
                                              <p style="margin: 0; font-size: 14px">
                                                <span style="font-size: 13px"
                                                  >Agradecemos a preferência!</span
                                                ><br /><span style="font-size: 13px"
                                                  >acesse nosso site:
                                                  https://github.com/DevBrunoRafael</span
                                                >
                                              </p>
                                            </div>
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                    <table
                      align="center"
                      border="0"
                      cellpadding="0"
                      cellspacing="0"
                      class="row row-3"
                      role="presentation"
                      style="
                        mso-table-lspace: 0pt;
                        mso-table-rspace: 0pt;
                        background-color: #ffffff;
                        background-image: url('images/bg_password.gif');
                        background-position: top center;
                        background-repeat: no-repeat;
                      "
                      width="100%"
                    >
                      <tbody>
                        <tr>
                          <td>
                            <table
                              align="center"
                              border="0"
                              cellpadding="0"
                              cellspacing="0"
                              class="row-content"
                              role="presentation"
                              style="
                                mso-table-lspace: 0pt;
                                mso-table-rspace: 0pt;
                                background-color: #ffffff;
                                color: #000000;
                                width: 600px;
                              "
                              width="600"
                            >
                              <tbody>
                                <tr>
                                  <td
                                    class="column column-1"
                                    style="
                                      mso-table-lspace: 0pt;
                                      mso-table-rspace: 0pt;
                                      font-weight: 400;
                                      text-align: left;
                                      vertical-align: top;
                                      padding-left: 35px;
                                      padding-right: 35px;
                                      padding-top: 15px;
                                      padding-bottom: 2px;
                                      border-top: 0px;
                                      border-right: 0px;
                                      border-bottom: 0px;
                                      border-left: 0px;
                                    "
                                    width="100%"
                                  >
                                    <table
                                      border="0"
                                      cellpadding="0"
                                      cellspacing="0"
                                      class="button_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td
                                          style="
                                            padding-bottom: 35px;
                                            padding-left: 10px;
                                            padding-right: 10px;
                                            padding-top: 5px;
                                            text-align: center;
                                          "
                                        >
                                          <div align="center">
                                            <!--[if mso]><v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" style="height:44px;width:244px;v-text-anchor:middle;" arcsize="114%" strokeweight="1.5pt" strokecolor="#FFFFFF" fillcolor="#FFD500"><w:anchorlock/><v:textbox inset="0px,0px,0px,0px"><center style="color:#ffffff; font-family:Arial, sans-serif; font-size:12px"><![endif]-->
                                            <div
                                              style="
                                                text-decoration: none;
                                                display: inline-block;
                                                color: #ffffff;
                                                background-color: #ffd500;
                                                border-radius: 50px;
                                                width: auto;
                                                border-top: 2px solid #ffffff;
                                                font-weight: 400;
                                                border-right: 1px solid #ffd500;
                                                border-bottom: 1px solid #ffd500;
                                                border-left: 1px solid #ffd500;
                                                padding-top: 5px;
                                                padding-bottom: 5px;
                                                font-family: Cabin, Arial,
                                                  Helvetica Neue, Helvetica, sans-serif;
                                                text-align: center;
                                                mso-border-alt: none;
                                                word-break: keep-all;
                                              "
                                            >
                                              <span
                                                style="
                                                  padding-left: 20px;
                                                  padding-right: 20px;
                                                  font-size: 12px;
                                                  display: inline-block;
                                                  letter-spacing: normal;
                                                "
                                                ><span
                                                  style="
                                                    font-size: 16px;
                                                    line-height: 2;
                                                    word-break: break-word;
                                                    mso-line-height-alt: 32px;
                                                  "
                                                  ><span
                                                    data-mce-style="font-size: 12px; line-height: 24px;"
                                                    style="
                                                      font-size: 12px;
                                                      line-height: 24px;
                                                    "
                                                    ><strong
                                                      >FAÇA O DOWNLOAD DO
                                                      EXTRATO </strong
                                                    ></span
                                                  ></span
                                                ></span
                                              >
                                            </div>
                                            <!--[if mso]></center></v:textbox></v:roundrect><![endif]-->
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                    <table
                      align="center"
                      border="0"
                      cellpadding="0"
                      cellspacing="0"
                      class="row row-4"
                      role="presentation"
                      style="mso-table-lspace: 0pt; mso-table-rspace: 0pt"
                      width="100%"
                    >
                      <tbody>
                        <tr>
                          <td>
                            <table
                              align="center"
                              border="0"
                              cellpadding="0"
                              cellspacing="0"
                              class="row-content"
                              role="presentation"
                              style="
                                mso-table-lspace: 0pt;
                                mso-table-rspace: 0pt;
                                background-color: #132f40;
                                color: #333;
                                width: 600px;
                              "
                              width="600"
                            >
                              <tbody>
                                <tr>
                                  <td
                                    class="column column-1"
                                    style="
                                      mso-table-lspace: 0pt;
                                      mso-table-rspace: 0pt;
                                      font-weight: 400;
                                      text-align: left;
                                      vertical-align: top;
                                      padding-left: 25px;
                                      border-top: 0px;
                                      border-right: 0px;
                                      border-bottom: 0px;
                                      border-left: 0px;
                                    "
                                    width="50%"
                                  >
                                    <table
                                      border="0"
                                      cellpadding="0"
                                      cellspacing="0"
                                      class="text_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                        word-break: break-word;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td
                                          style="
                                            padding-bottom: 25px;
                                            padding-left: 10px;
                                            padding-right: 10px;
                                            padding-top: 25px;
                                          "
                                        >
                                          <div style="font-family: sans-serif">
                                            <div
                                              class="txtTinyMce-wrapper"
                                              style="
                                                font-size: 12px;
                                                mso-line-height-alt: 14.399999999999999px;
                                                color: #f8f8f8;
                                                line-height: 1.2;
                                                font-family: Cabin, Arial,
                                                  Helvetica Neue, Helvetica, sans-serif;
                                              "
                                            >
                                              <p style="margin: 0; font-size: 11px">
                                                <span style="font-size: 11px"
                                                  ><strong>Tech Bank</strong></span
                                                >
                                              </p>
                                              <p style="margin: 0; font-size: 11px">
                                                <span style="font-size: 11px"
                                                  >Mangue</span
                                                ><span style="font-size: 11px">
                                                  Grande, 138 Acre</span
                                                >
                                              </p>
                                            </div>
                                          </div>
                                        </td>
                                      </tr>
                                    </table>
                                  </td>
                                  <td
                                    class="column column-2"
                                    style="
                                      mso-table-lspace: 0pt;
                                      mso-table-rspace: 0pt;
                                      font-weight: 400;
                                      text-align: left;
                                      vertical-align: top;
                                      border-top: 0px;
                                      border-right: 0px;
                                      border-bottom: 0px;
                                      border-left: 0px;
                                    "
                                    width="50%"
                                  >
                                    <table
                                      border="0"
                                      cellpadding="0"
                                      cellspacing="0"
                                      class="social_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td
                                          style="
                                            padding-bottom: 20px;
                                            padding-left: 15px;
                                            padding-right: 15px;
                                            padding-top: 20px;
                                            text-align: center;
                                          "
                                        >
                                          <table
                                            align="center"
                                            border="0"
                                            cellpadding="0"
                                            cellspacing="0"
                                            class="social-table"
                                            role="presentation"
                                            style="
                                              mso-table-lspace: 0pt;
                                              mso-table-rspace: 0pt;
                                            "
                                            width="126px"
                                          >
                                            <tr>
                                              <td style="padding: 0 5px 0 5px">
                                                <a
                                                  href="https://www.instagram.com/brunorafael_ns/"
                                                  target="_blank"
                                                  ><img
                                                    alt="Instagram"
                                                    height="32"
                                                    src="images/instagram2x.png"
                                                    style="
                                                      display: block;
                                                      height: auto;
                                                      border: 0;
                                                    "
                                                    title="instagram"
                                                    width="32"
                                                /></a>
                                              </td>
                                              <td style="padding: 0 5px 0 5px">
                                                <a
                                                  href="https://telegram.org"
                                                  target="_blank"
                                                  ><img
                                                    alt="Telegram"
                                                    height="32"
                                                    src="images/telegram2x.png"
                                                    style="
                                                      display: block;
                                                      height: auto;
                                                      border: 0;
                                                    "
                                                    title="Telegram"
                                                    width="32"
                                                /></a>
                                              </td>
                                              <td style="padding: 0 5px 0 5px">
                                                <a
                                                  href="https://wa.me/5579998425258"
                                                  target="_blank"
                                                  ><img
                                                    alt="WhatsApp"
                                                    height="32"
                                                    src="images/whatsapp2x.png"
                                                    style="
                                                      display: block;
                                                      height: auto;
                                                      border: 0;
                                                    "
                                                    title="WhatsApp"
                                                    width="32"
                                                /></a>
                                              </td>
                                            </tr>
                                          </table>
                                        </td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                    <table
                      align="center"
                      border="0"
                      cellpadding="0"
                      cellspacing="0"
                      class="row row-5"
                      role="presentation"
                      style="mso-table-lspace: 0pt; mso-table-rspace: 0pt"
                      width="100%"
                    >
                      <tbody>
                        <tr>
                          <td>
                            <table
                              align="center"
                              border="0"
                              cellpadding="0"
                              cellspacing="0"
                              class="row-content stack"
                              role="presentation"
                              style="
                                mso-table-lspace: 0pt;
                                mso-table-rspace: 0pt;
                                color: #000000;
                                width: 600px;
                              "
                              width="600"
                            >
                              <tbody>
                                <tr>
                                  <td
                                    class="column column-1"
                                    style="
                                      mso-table-lspace: 0pt;
                                      mso-table-rspace: 0pt;
                                      font-weight: 400;
                                      text-align: left;
                                      vertical-align: top;
                                      padding-top: 5px;
                                      padding-bottom: 5px;
                                      border-top: 0px;
                                      border-right: 0px;
                                      border-bottom: 0px;
                                      border-left: 0px;
                                    "
                                    width="100%"
                                  >
                                    <table
                                      border="0"
                                      cellpadding="0"
                                      cellspacing="0"
                                      class="icons_block"
                                      role="presentation"
                                      style="
                                        mso-table-lspace: 0pt;
                                        mso-table-rspace: 0pt;
                                      "
                                      width="100%"
                                    >
                                      <tr>
                                        <td
                                          style="
                                            vertical-align: middle;
                                            color: #9d9d9d;
                                            font-family: inherit;
                                            font-size: 15px;
                                            padding-bottom: 5px;
                                            padding-top: 5px;
                                            text-align: center;
                                          "
                                        >
                                          <table
                                            cellpadding="0"
                                            cellspacing="0"
                                            role="presentation"
                                            style="
                                              mso-table-lspace: 0pt;
                                              mso-table-rspace: 0pt;
                                            "
                                            width="100%"
                                          >
                                            <tr>
                                              <td
                                                style="
                                                  vertical-align: middle;
                                                  text-align: center;
                                                "
                                              >
                                                  <!--<![endif]-->
                                                </table>
                                              </td>
                                            </tr>
                                          </table>
                                        </td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </tbody>
                            </table>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </td>
                </tr>
              </tbody>
            </table>
            <!-- End -->
          </body>
        </html>
                           
        """;
}
