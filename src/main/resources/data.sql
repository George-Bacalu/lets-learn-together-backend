INSERT INTO sections (name, icon_id, image_id) VALUES
('Video Section', 1, 1), -- getStringResource(R.string.video_section), R.drawable.ic_video_section, R.drawable.video_section
('Text to Sign Section', 2, 2), -- getStringResource(R.string.text_to_sign_section), R.drawable.ic_text_to_sign_section, R.drawable.text_to_sign_section
('Voice to Sign Section', 3, 3), -- getStringResource(R.voice_to_sign_section.video_section), R.drawable.ic_voice_to_sign_section, R.drawable.voice_to_sign_section
('Expressions Section', 4, 4) -- getStringResource(R.string.expressions_section), R.drawable.ic_expressions_section, R.drawable.expressions_section
ON CONFLICT DO NOTHING;

INSERT INTO categories (name, image_id, parent_id, section_id) VALUES
('ALFABET', 1, null, 1), -- getStringResource(R.string.ALFABET), R.drawable.alfabet
('NUMERE', 2, null, 1), -- getStringResource(R.string.NUMERE), R.drawable.numere
('CULORI', 3, null, 1), -- getStringResource(R.string.CULORI), R.drawable.culori
('ANIMALE', 4, null, 1), -- getStringResource(R.string.ANIMALE), R.drawable.animale
('OBIECTE', 5, null, 1), -- getStringResource(R.string.OBIECTE), R.drawable.obiecte
('PERSOANE', 6, null, 1), -- getStringResource(R.string.PERSOANE), R.drawable.persoane
('EMOTII', 7, null, 1), -- getStringResource(R.string.EMOTII), R.drawable.emotii
('VERBE', 8, null, 1), -- getStringResource(R.string.VERBE), R.drawable.verbe
('FORMULE DE ADRESARE', 9, null, 1), -- getStringResource(R.string.FORMULE_ADRESARE), R.drawable.formule_adresare
('A', 10, 1, 1), -- getStringResource(R.string.A), R.drawable.a
(N'Ă', 11, 1, 1), -- getStringResource(R.string.A_BREVE), R.drawable.a_breve
(N'Â', 12, 1, 1), -- getStringResource(R.string.A_CIRCUMFLEX), R.drawable.a_circumflex
('B', 13, 1, 1), -- getStringResource(R.string.B), R.drawable.b
('C', 14, 1, 1), -- getStringResource(R.string.C), R.drawable.c
('D', 15, 1, 1), -- getStringResource(R.string.D), R.drawable.d
('E', 16, 1, 1), -- getStringResource(R.string.E), R.drawable.e
('F', 17, 1, 1), -- getStringResource(R.string.F), R.drawable.f
('G', 18, 1, 1), -- getStringResource(R.string.G), R.drawable.g
('H', 19, 1, 1), -- getStringResource(R.string.H), R.drawable.h
('I', 20, 1, 1), -- getStringResource(R.string.I), R.drawable.i
(N'Î', 21, 1, 1), -- getStringResource(R.string.I_CIRCUMFLEX), R.drawable.i_circumflex
('J', 22, 1, 1), -- getStringResource(R.string.J), R.drawable.j
('K', 23, 1, 1), -- getStringResource(R.string.K), R.drawable.k
('L', 24, 1, 1), -- getStringResource(R.string.L), R.drawable.l
('M', 25, 1, 1), -- getStringResource(R.string.M), R.drawable.m
('N', 26, 1, 1), -- getStringResource(R.string.N), R.drawable.n
('O', 27, 1, 1), -- getStringResource(R.string.O), R.drawable.o
('P', 28, 1, 1), -- getStringResource(R.string.P), R.drawable.p
('Q', 29, 1, 1), -- getStringResource(R.string.Q), R.drawable.q
('R', 30, 1, 1), -- getStringResource(R.string.R), R.drawable.r
('S', 31, 1, 1), -- getStringResource(R.string.S), R.drawable.s
(N'Ș', 32, 1, 1), -- getStringResource(R.string.S_COMMA), R.drawable.s_comma
('T', 33, 1, 1), -- getStringResource(R.string.T), R.drawable.t
(N'Ț', 34, 1, 1), -- getStringResource(R.string.T_COMMA), R.drawable.t_comma
('U', 35, 1, 1), -- getStringResource(R.string.U), R.drawable.u
('V', 36, 1, 1), -- getStringResource(R.string.V), R.drawable.v
('W', 37, 1, 1), -- getStringResource(R.string.W), R.drawable.w
('X', 38, 1, 1), -- getStringResource(R.string.X), R.drawable.x
('Y', 39, 1, 1), -- getStringResource(R.string.Y), R.drawable.y
('Z', 40, 1, 1), -- getStringResource(R.string.Z), R.drawable.z
('UNU', 41, 2, 1), -- getStringResource(R.string.UNU), R.drawable.unu
('DOI', 42, 2, 1), -- getStringResource(R.string.DOI), R.drawable.doi
('TREI', 43, 2, 1), -- getStringResource(R.string.TREI), R.drawable.trei
('PATRU', 44, 2, 1), -- getStringResource(R.string.PATRU), R.drawable.patru
('CINCI', 45, 2, 1), -- getStringResource(R.string.CINCI), R.drawable.cinci
('SASE', 46, 2, 1), -- getStringResource(R.string.SASE), R.drawable.sase
('SAPTE', 47, 2, 1), -- getStringResource(R.string.SAPTE), R.drawable.sapte
('OPT', 48, 2, 1), -- getStringResource(R.string.OPT), R.drawable.opt
('NOUA', 49, 2, 1), -- getStringResource(R.string.NOUA), R.drawable.noua
('ZECE', 50, 2, 1), -- getStringResource(R.string.ZECE), R.drawable.zece
('ROSU', 51, 3, 1), -- getStringResource(R.string.ROSU), R.drawable.rosu
('PORTOCALIU', 52, 3, 1), -- getStringResource(R.string.PORTOCALIU), R.drawable.portocaliu
('GALBEN', 53, 3, 1), -- getStringResource(R.string.GALBEN), R.drawable.galben
('VERDE', 54, 3, 1), -- getStringResource(R.string.VERDE), R.drawable.verde
('ALBASTRU', 55, 3, 1), -- getStringResource(R.string.ALBASTRU), R.drawable.albastru
('INDIGO', 56, 3, 1), -- getStringResource(R.string.INDIGO), R.drawable.indigo
('VIOLET', 57, 3, 1), -- getStringResource(R.string.VIOLET), R.drawable.violet
('ALB', 58, 3, 1), -- getStringResource(R.string.ALB), R.drawable.alb
('GRI', 59, 3, 1), -- getStringResource(R.string.GRI), R.drawable.gri
('MARO', 60, 3, 1), -- getStringResource(R.string.MARO), R.drawable.maro
('ROZ', 61, 3, 1), -- getStringResource(R.string.ROZ), R.drawable.roz
('TURCOAZ', 62, 3, 1), -- getStringResource(R.string.TURCOAZ), R.drawable.turcoaz
('NEGRU', 63, 3, 1), -- getStringResource(R.string.NEGRU), R.drawable.negru
('ANIMALE DOMESTICE', 64, 4, 1), -- getStringResource(R.string.ANIMALE_DOMESTICE), R.drawable.animale_domestice
('ANIMALE SALBATICE', 65, 4, 1), -- getStringResource(R.string.ANIMALE_SALBATICE), R.drawable.animale_salbatice
('CAINE', 66, 64, 1), -- getStringResource(R.string.CAINE), R.drawable.caine
('PISICA', 67, 64, 1), -- getStringResource(R.string.PISICA), R.drawable.pisica
('PORC', 68, 64, 1), -- getStringResource(R.string.PORC), R.drawable.porc
('CAPRA', 69, 64, 1), -- getStringResource(R.string.CAPRA), R.drawable.capra
('GAINA', 70, 64, 1), -- getStringResource(R.string.GAINA), R.drawable.gaina
('IEPURE', 71, 64, 1), -- getStringResource(R.string.IEPURE), R.drawable.iepure
('PUI', 72, 64, 1), -- getStringResource(R.string.PUI), R.drawable.pui
('VACA', 73, 64, 1), -- getStringResource(R.string.VACA), R.drawable.vaca
('CAL', 74, 64, 1), -- getStringResource(R.string.CAL), R.drawable.cal
('COCOS', 75, 64, 1), -- getStringResource(R.string.COCOS), R.drawable.cocos
('GASCA', 76, 64, 1), -- getStringResource(R.string.GASCA), R.drawable.gasca
('OAIE', 77, 64, 1), -- getStringResource(R.string.OAIE), R.drawable.oaie
('RATA', 78, 64, 1), -- getStringResource(R.string.RATA), R.drawable.rata
('LUP', 79, 65, 1), -- getStringResource(R.string.LUP), R.drawable.lup
('VULPE', 80, 65, 1), -- getStringResource(R.string.VULPE), R.drawable.vulpe
('ARICI', 81, 65, 1), -- getStringResource(R.string.ARICI), R.drawable.arici
('LEU', 82, 65, 1), -- getStringResource(R.string.LEU), R.drawable.leu
('VEVERITA', 83, 65, 1), -- getStringResource(R.string.VEVERITA), R.drawable.veverita
('ZIMBRU', 84, 65, 1), -- getStringResource(R.string.ZIMBRU), R.drawable.zimbru
('URS POLAR', 85, 65, 1), -- getStringResource(R.string.URS_POLAR), R.drawable.urs_polar
('ELEFANT', 86, 65, 1), -- getStringResource(R.string.ELEFANT), R.drawable.elefant
('CROCODIL', 87, 65, 1), -- getStringResource(R.string.CROCODIL), R.drawable.crocodil
('ACASA', 88, 5, 1), -- getStringResource(R.string.ACASA), R.drawable.acasa
('AFARA', 89, 5, 1), -- getStringResource(R.string.AFARA), R.drawable.afara
('CLASA', 90, 5, 1), -- getStringResource(R.string.CLASA), R.drawable.clasa
('MAGAZIN', 91, 5, 1), -- getStringResource(R.string.MAGAZIN), R.drawable.magazin
('ORAS', 92, 5, 1), -- getStringResource(R.string.ORAS), R.drawable.oras
('PAT', 93, 88, 1), -- getStringResource(R.string.PAT), R.drawable.pat
('TELEVIZOR', 94, 88, 1), -- getStringResource(R.string.TELEVIZOR), R.drawable.televizor
('CALCULATOR', 95, 88, 1), -- getStringResource(R.string.CALCULATOR), R.drawable.calculator
('DULAP', 96, 88, 1), -- getStringResource(R.string.DULAP), R.drawable.dulap
('LINGURA', 97, 88, 1), -- getStringResource(R.string.LINGURA), R.drawable.lingura
('SCAUN', 98, 88, 1), -- getStringResource(R.string.SCAUN), R.drawable.scaun
('MASA', 99, 88, 1), -- getStringResource(R.string.MASA), R.drawable.masa
('FRIGIDER', 100, 88, 1), -- getStringResource(R.string.FRIGIDER), R.drawable.frigider
('CUTIT', 101, 88, 1), -- getStringResource(R.string.CUTIT), R.drawable.cutit
('TOPOR', 102, 89, 1), -- getStringResource(R.string.TOPOR), R.drawable.topor
('POARTA', 103, 89, 1), -- getStringResource(R.string.POARTA), R.drawable.poarta
('GEAM', 104, 89, 1), -- getStringResource(R.string.GEAM), R.drawable.geam
('FURCA', 105, 89, 1), -- getStringResource(R.string.FURCA), R.drawable.furca
('COPAC', 106, 89, 1), -- getStringResource(R.string.COPAC), R.drawable.copac
('GARD', 107, 89, 1), -- getStringResource(R.string.GARD), R.drawable.gard
('COASA', 108, 89, 1), -- getStringResource(R.string.COASA), R.drawable.coasa
('BEC', 109, 89, 1), -- getStringResource(R.string.BEC), R.drawable.bec
('LOPATA', 110, 89, 1), -- getStringResource(R.string.LOPATA), R.drawable.lopata
('USA', 111, 89, 1), -- getStringResource(R.string.USA), R.drawable.usa
('MANUAL', 112, 90, 1), -- getStringResource(R.string.MANUAL), R.drawable.manual
('PIX', 113, 90, 1), -- getStringResource(R.string.PIX), R.drawable.pix
('DICTIONAR', 114, 90, 1), -- getStringResource(R.string.DICTIONAR), R.drawable.dictionar
('CARTE', 115, 90, 1), -- getStringResource(R.string.CARTE), R.drawable.carte
('BANCA', 116, 90, 1), -- getStringResource(R.string.BANCA), R.drawable.banca
('TEMA', 117, 90, 1), -- getStringResource(R.string.TEMA), R.drawable.tema
('VIDEO PROIECTOR', 118, 90, 1), -- getStringResource(R.string.VIDEO_PROIECTOR), R.drawable.video_proiector
('TEST', 119, 90, 1), -- getStringResource(R.string.TEST), R.drawable.test
('STILOU', 120, 90, 1), -- getStringResource(R.string.STILOU), R.drawable.stilou
('TEST GRILA', 121, 90, 1), -- getStringResource(R.string.TEST_GRILA), R.drawable.test_grila
('RADIERA', 122, 90, 1), -- getStringResource(R.string.RADIERA), R.drawable.radiera
('CRETA', 123, 90, 1), -- getStringResource(R.string.CRETA), R.drawable.creta
('CATEDRA', 124, 90, 1), -- getStringResource(R.string.CATEDRA), R.drawable.catedra
('CREION', 125, 90, 1), -- getStringResource(R.string.CREION), R.drawable.creion
('CAIET', 126, 90, 1), -- getStringResource(R.string.CAIET), R.drawable.caiet
('BANI', 127, 91, 1), -- getStringResource(R.string.BANI), R.drawable.bani
('PRODUSE', 128, 91, 1), -- getStringResource(R.string.PRODUSE), R.drawable.produse
('EURO', 129, 127, 1), -- getStringResource(R.string.EURO), R.drawable.euro
('DOLAR', 130, 127, 1), -- getStringResource(R.string.DOLAR), R.drawable.dolar
('MONEDA', 131, 127, 1), -- getStringResource(R.string.MONEDA), R.drawable.moneda
('BANCNOTA', 132, 127, 1), -- getStringResource(R.string.BANCNOTA), R.drawable.bancnota
('SUC', 133, 128, 1), -- getStringResource(R.string.SUC), R.drawable.suc
('PRAJITURA', 134, 128, 1), -- getStringResource(R.string.PRAJITURA), R.drawable.prajitura
('MORCOV', 135, 128, 1), -- getStringResource(R.string.MORCOV), R.drawable.morcov
('CIOCOLATA', 136, 128, 1), -- getStringResource(R.string.CIOCOLATA), R.drawable.ciocolata
('PAINE', 137, 128, 1), -- getStringResource(R.string.PAINE), R.drawable.paine
('CEAPA', 138, 128, 1), -- getStringResource(R.string.CEAPA), R.drawable.ceapa
('ULEI', 139, 128, 1), -- getStringResource(R.string.ULEI), R.drawable.ulei
('CASTRAVETI', 140, 128, 1), -- getStringResource(R.string.CASTRAVETI), R.drawable.castraveti
('CARTOFI', 141, 128, 1), -- getStringResource(R.string.CARTOFI), R.drawable.cartofi
('CASCAVAL', 142, 128, 1), -- getStringResource(R.string.CASCAVAL), R.drawable.cascaval
('ARDEI', 143, 128, 1), -- getStringResource(R.string.ARDEI), R.drawable.ardei
('BRANZA', 144, 128, 1), -- getStringResource(R.string.BRANZA), R.drawable.branza
('SCOALA', 145, 92, 1), -- getStringResource(R.string.SCOALA), R.drawable.scoala
('LEAGAN', 146, 92, 1), -- getStringResource(R.string.LEAGAN), R.drawable.leagan
('SPITAL', 147, 92, 1), -- getStringResource(R.string.SPITAL), R.drawable.spital
('AUTOBUZ', 148, 92, 1), -- getStringResource(R.string.AUTOBUZ), R.drawable.autobuz
('STALP', 149, 92, 1), -- getStringResource(R.string.STALP), R.drawable.stalp
('BLOC', 150, 92, 1), -- getStringResource(R.string.BLOC), R.drawable.bloc
('TAXI', 151, 92, 1), -- getStringResource(R.string.TAXI), R.drawable.taxi
('LOC DE PARCARE', 152, 92, 1), -- getStringResource(R.string.LOC_DE_PARCARE), R.drawable.loc_de_parcare
('TRAMVAI', 153, 92, 1), -- getStringResource(R.string.TRAMVAI), R.drawable.tramvai
('POLITIE', 154, 92, 1), -- getStringResource(R.string.POLITIE), R.drawable.politie
('MEMBRII FAMILIEI', 155, 6, 1), -- getStringResource(R.string.MEMBRII_FAMILIEI), R.drawable.membrii_familiei
('PRONUME', 156, 6, 1), -- getStringResource(R.string.PRONUME), R.drawable.pronume
('TATA', 157, 155, 1), -- getStringResource(R.string.TATA), R.drawable.tata
('MAMA', 158, 155, 1), -- getStringResource(R.string.MAMA), R.drawable.mama
('FRATE', 159, 155, 1), -- getStringResource(R.string.FRATE), R.drawable.frate
('SORA', 160, 155, 1), -- getStringResource(R.string.SORA), R.drawable.sora
('UNCHI', 161, 155, 1), -- getStringResource(R.string.UNCHI), R.drawable.unchi
('MATUSA', 162, 155, 1), -- getStringResource(R.string.MATUSA), R.drawable.matusa
('BUNIC BUNICA', 163, 155, 1), -- getStringResource(R.string.BUNIC_BUNICA), R.drawable.bunic
('NAS NASA', 164, 155, 1), -- getStringResource(R.string.NAS_NASA), R.drawable.nas
('EU', 165, 156, 1), -- getStringResource(R.string.EU), R.drawable.eu
('TU', 166, 156, 1), -- getStringResource(R.string.TU), R.drawable.tu
('EL', 167, 156, 1), -- getStringResource(R.string.EL), R.drawable.el
('EA', 168, 156, 1), -- getStringResource(R.string.EA), R.drawable.ea
('NOI', 169, 156, 1), -- getStringResource(R.string.NOI), R.drawable.noi
('VOI', 170, 156, 1), -- getStringResource(R.string.VOI), R.drawable.voi
('EI ELE', 171, 156, 1), -- getStringResource(R.string.EI_ELE), R.drawable.ei_ele
('VESEL', 172, 7, 1), -- getStringResource(R.string.VESEL), R.drawable.vesel
('SATURAT', 173, 7, 1), -- getStringResource(R.string.SATURAT), R.drawable.saturat
('INCRUNTAT', 174, 7, 1), -- getStringResource(R.string.INCRUNTAT), R.drawable.incruntat
('TRIST', 175, 7, 1), -- getStringResource(R.string.TRIST), R.drawable.trist
('DEZAMAGIT', 176, 7, 1), -- getStringResource(R.string.DEZAMAGIT), R.drawable.dezamagit
('NERVOS', 177, 7, 1), -- getStringResource(R.string.NERVOS), R.drawable.nervos
('FERICIT', 178, 7, 1), -- getStringResource(R.string.FERICIT), R.drawable.fericit
('SUPARAT', 179, 7, 1), -- getStringResource(R.string.SUPARAT), R.drawable.suparat
('INDURERAT', 180, 7, 1), -- getStringResource(R.string.INDURERAT), R.drawable.indurerat
('ENTUZIASMAT', 181, 7, 1), -- getStringResource(R.string.ENTUZIASMAT), R.drawable.entuziasmat
('INDRAGOSTIT', 182, 7, 1), -- getStringResource(R.string.INDRAGOSTIT), R.drawable.indragostit
('LINISTIT', 183, 7, 1), -- getStringResource(R.string.LINISTIT), R.drawable.linistit
('CUMINTE', 184, 7, 1), -- getStringResource(R.string.CUMINTE), R.drawable.cuminte
('CONSTRUI', 185, 8, 1), -- getStringResource(R.string.CONSTRUI), R.drawable.construi
('SCRIE', 186, 8, 1), -- getStringResource(R.string.SCRIE), R.drawable.scrie
('TRAGE', 187, 8, 1), -- getStringResource(R.string.TRAGE), R.drawable.trage
('CITI', 188, 8, 1), -- getStringResource(R.string.CITI), R.drawable.citi
('STA JOS', 189, 8, 1), -- getStringResource(R.string.STA_JOS), R.drawable.sta_jos
('LASA', 190, 8, 1), -- getStringResource(R.string.LASA), R.drawable.lasa
('APASA', 191, 8, 1), -- getStringResource(R.string.APASA), R.drawable.apasa
('PUNE', 192, 8, 1), -- getStringResource(R.string.PUNE), R.drawable.pune
('STRANGE', 193, 8, 1), -- getStringResource(R.string.STRANGE), R.drawable.strange
('SCOATE', 194, 8, 1), -- getStringResource(R.string.SCOATE), R.drawable.scoate
('SPUNE', 195, 8, 1), -- getStringResource(R.string.SPUNE), R.drawable.spune
('SE UITA', 196, 8, 1), -- getStringResource(R.string.SE_UITA), R.drawable.se_uita
('VA ROG', 197, 9, 1), -- getStringResource(R.string.VA_ROG), R.drawable.va_rog
('MULTUMESC', 198, 9, 1), -- getStringResource(R.string.MULTUMESC), R.drawable.multumesc
('SCUZE', 199, 9, 1), -- getStringResource(R.string.SCUZE), R.drawable.scuze
('HAI', 200, 9, 1), -- getStringResource(R.string.HAI), R.drawable.hai
('ACEASTA ESTE PRIETENA MEA', 201, null, 4), -- getStringResource(R.string.aceasta_este_prietena_mea), R.drawable.aceasta_este_prietena_mea
('ACESTA ESTE COLEGUL MEU', 202, null, 4), -- getStringResource(R.string.acesta_este_colegul_meu), R.drawable.acesta_este_colegul_meu
('ACESTA ESTE SOTUL MEU', 203, null, 4), -- getStringResource(R.string.acesta_este_sotul_meu), R.drawable.acesta_este_sotul_meu
('AM INTELES', 204, null, 4), -- getStringResource(R.string.am_inteles), R.drawable.am_inteles
('AM SA VA FAC CUNOSTINTA', 205, null, 4), -- getStringResource(R.string.am_sa_va_fac_cunostinta), R.drawable.am_sa_va_fac_cunostinta
('AS DORI SA ITI CER SFATUL', 206, null, 4) -- getStringResource(R.string.as_dori_sa_iti_cer_sfatul), R.drawable.as_dori_sa_iti_cer_sfatul
ON CONFLICT DO NOTHING;

INSERT INTO letter_sign_pairs (letter, image_id) VALUES
('Ă', 207), -- getStringResource(R.string.a), R.drawable.dactilema_a
(N'ă', 208), -- getStringResource(R.string.ă), R.drawable.dactilema_ă
(N'â', 209), -- getStringResource(R.string.â), R.drawable.dactilema_â
('b', 210), -- getStringResource(R.string.b), R.drawable.dactilema_b
('c', 211), -- getStringResource(R.string.c), R.drawable.dactilema_c
('d', 212), -- getStringResource(R.string.d), R.drawable.dactilema_d
('e', 213), -- getStringResource(R.string.e), R.drawable.dactilema_e
('f', 214), -- getStringResource(R.string.f), R.drawable.dactilema_f
('g', 215), -- getStringResource(R.string.g), R.drawable.dactilema_g
('h', 216), -- getStringResource(R.string.h), R.drawable.dactilema_h
('i', 217), -- getStringResource(R.string.i), R.drawable.dactilema_i
(N'î', 218), -- getStringResource(R.string.î), R.drawable.dactilema_î
('j', 219), -- getStringResource(R.string.j), R.drawable.dactilema_j
('k', 220), -- getStringResource(R.string.k), R.drawable.dactilema_k
('l', 221), -- getStringResource(R.string.l), R.drawable.dactilema_l
('m', 222), -- getStringResource(R.string.m), R.drawable.dactilema_m
('n', 223), -- getStringResource(R.string.n), R.drawable.dactilema_n
('o', 224), -- getStringResource(R.string.o), R.drawable.dactilema_o
('p', 225), -- getStringResource(R.string.p), R.drawable.dactilema_p
('q', 226), -- getStringResource(R.string.q), R.drawable.dactilema_q
('r', 227), -- getStringResource(R.string.r), R.drawable.dactilema_r
('s', 228), -- getStringResource(R.string.s), R.drawable.dactilema_s
(N'ș', 229), -- getStringResource(R.string.ș), R.drawable.dactilema_ș
('t', 230), -- getStringResource(R.string.t), R.drawable.dactilema_t
(N'ț', 231), -- getStringResource(R.string.ț), R.drawable.dactilema_ț
('u', 232), -- getStringResource(R.string.u), R.drawable.dactilema_u
('v', 233), -- getStringResource(R.string.v), R.drawable.dactilema_v
('w', 234), -- getStringResource(R.string.w), R.drawable.dactilema_w
('x', 235), -- getStringResource(R.string.x), R.drawable.dactilema_x
('y', 236), -- getStringResource(R.string.y), R.drawable.dactilema_y
('z', 237), -- getStringResource(R.string.z), R.drawable.dactilema_z
('A', 238), -- getStringResource(R.string.A), R.drawable.dactilema_A
(N'Ă', 239), -- getStringResource(R.string.Ă), R.drawable.dactilema_Ă
(N'Â', 240), -- getStringResource(R.string.Â), R.drawable.dactilema_Â
('B', 241), -- getStringResource(R.string.B), R.drawable.dactilema_B
('C', 242), -- getStringResource(R.string.C), R.drawable.dactilema_C
('D', 243), -- getStringResource(R.string.D), R.drawable.dactilema_D
('E', 244), -- getStringResource(R.string.E), R.drawable.dactilema_E
('F', 245), -- getStringResource(R.string.F), R.drawable.dactilema_F
('G', 246), -- getStringResource(R.string.G), R.drawable.dactilema_G
('H', 247), -- getStringResource(R.string.H), R.drawable.dactilema_H
('I', 248), -- getStringResource(R.string.I), R.drawable.dactilema_I
(N'Î', 249), -- getStringResource(R.string.Î), R.drawable.dactilema_Î
('J', 250), -- getStringResource(R.string.J), R.drawable.dactilema_J
('K', 251), -- getStringResource(R.string.K), R.drawable.dactilema_K
('L', 252), -- getStringResource(R.string.L), R.drawable.dactilema_L
('M', 253), -- getStringResource(R.string.M), R.drawable.dactilema_M
('N', 254), -- getStringResource(R.string.N), R.drawable.dactilema_N
('O', 255), -- getStringResource(R.string.O), R.drawable.dactilema_O
('P', 256), -- getStringResource(R.string.P), R.drawable.dactilema_P
('Q', 257), -- getStringResource(R.string.Q), R.drawable.dactilema_Q
('R', 258), -- getStringResource(R.string.R), R.drawable.dactilema_R
('S', 259), -- getStringResource(R.string.S), R.drawable.dactilema_S
(N'Ș', 260), -- getStringResource(R.string.Ș), R.drawable.dactilema_Ș
('T', 261), -- getStringResource(R.string.T), R.drawable.dactilema_T
(N'Ț', 262), -- getStringResource(R.string.Ț), R.drawable.dactilema_Ț
('U', 263), -- getStringResource(R.string.U), R.drawable.dactilema_U
('V', 264), -- getStringResource(R.string.V), R.drawable.dactilema_V
('W', 265), -- getStringResource(R.string.W), R.drawable.dactilema_W
('X', 266), -- getStringResource(R.string.X), R.drawable.dactilema_X
('Y', 267), -- getStringResource(R.string.Y), R.drawable.dactilema_Y
('Z', 268), -- getStringResource(R.string.Z), R.drawable.dactilema_Z
(' ', 269) -- " ", R.drawable.space
ON CONFLICT DO NOTHING;

INSERT INTO roles (authority) VALUES ('USER'), ('ADMIN')
ON CONFLICT DO NOTHING;

INSERT INTO institutions (school, classroom) VALUES ('Scoala Gimnaziala Nr. 1', '7A'), ('Scoala Gimnaziala Nr. 2', '8A'), ('Scoala Gimnaziala Nr. 3', '8B')
ON CONFLICT DO NOTHING;

INSERT INTO users (name, email, password, mobile, address, birthday, institution_id, role_id) VALUES
('John Doe', 'john.doe@email.com', '#John_Doe_Password0', '+40721543701', '123 Main St, Boston, Constanta', '1980-02-15', 1, 2),
('Jane Smith', 'jane.smith@email.com', '#Jane_Smith_Password0', '+40756321802', '456 Oak St, London, Constanta', '1982-07-10', 1, 1),
('Michael Johnson', 'michael.johnson@email.com', '#Michael_Johnson_Password0', '+40789712303', '789 Pine St, Madrid, Constanta', '1990-11-20', 1, 1)
ON CONFLICT DO NOTHING;

INSERT INTO feedbacks (type, description, sent_at, user_id) VALUES
('ISSUE', 'Aplicatia se blocheaza atunci cand se trimite un formular.', '2023-04-20 14:30', 1),
('OPTIMIZATION', 'Imbunatatiti timpul de incarcare a paginii de dashboard.', '2023-04-21 09:15', 2),
('IMPROVEMENT', 'Adaugati un mod intunecat pentru o experienta de utilizare mai buna.', '2023-04-22 16:45', 3)
ON CONFLICT DO NOTHING;

INSERT INTO notifications (message, sender_id, receiver_id, sent_at) VALUES
('John a impartasit cu tine o categorie', 1, 2, '2023-06-07 13:00:00'),
('John a impartasit cu tine o categorie', 1, 3, '2023-06-07 13:00:00'),
('Jane a impartasit cu tine o categorie', 2, 1, '2023-06-08 12:00:00'),
('Jane a impartasit cu tine o categorie', 2, 3, '2023-06-08 12:00:00')
ON CONFLICT DO NOTHING;