CREATE OR REPLACE FORCE VIEW scolarite.v_droits_login (dlog_key,
                                                       dlog_login,
                                                       dlog_nom,
                                                       dlog_prenom,
                                                       dlog_valide,
                                                       administrateur
                                                      )
AS
   SELECT DISTINCT l.dlog_key, l.dlog_login, l.dlog_nom, l.dlog_prenom,
                   l.dlog_valide,
                   DECODE (p.param_value, NULL, 'N', 'O') administrateur
              FROM scolarite.scol_droit_login l, scolarite.scol_parametres p
             WHERE l.dlog_login = p.param_value(+)
                   AND p.param_key(+) = 'SCOL_DROITS_AUTORISATION'
                   WITH READ ONLY;
                   
                   
CREATE OR REPLACE FORCE VIEW scolarite.v_droit_trombi_ec (fann_key,
                                                          dlog_login,
                                                          fdip_code,
                                                          fspn_key,
                                                          mpar_key,
                                                          msem_key,
                                                          mec_key,
                                                          fhab_key,
                                                          fhab_niveau
                                                         )
AS
   SELECT ru.fann_key, dl.dlog_login, s.fdip_code, p.fspn_key, rs.mpar_key,
          ru.msem_key, re.mec_key, h.fhab_key, h.fhab_niveau
     FROM scolarite.scol_maquette_repartition_ue ru,
          scolarite.scol_maquette_repartition_ec re,
          scolarite.scol_maquette_repartition_sem rs,
          scolarite.scol_maquette_parcours p,
          scolarite.scol_maquette_semestre msem,
          scolarite.scol_formation_specialisation s,
          scolarite.scol_formation_habilitation h,
          scolarite.scol_droit_login dl,                              -- ajout
          scolarite.scol_droit_diplome dd
    WHERE rs.mpar_key = p.mpar_key
      AND ru.msem_key = rs.msem_key
      AND re.mue_key = ru.mue_key
      AND s.fspn_key = p.fspn_key
      AND ru.fann_key = rs.fann_key
      AND re.fann_key = ru.fann_key
      AND msem.msem_key = rs.msem_key
      AND h.fspn_key = s.fspn_key
      AND h.fann_key = re.fann_key
      AND dd.fann_key = h.fann_key
      AND dd.dlog_key = dl.dlog_key
      AND dd.fhab_key = h.fhab_key
      AND h.fhab_ouvert = 'O';

CREATE OR REPLACE FORCE VIEW scolarite.v_droit_formation (fhab_key,
                                                          dlog_login,
                                                          fdip_code,
                                                          fgra_code,
                                                          fhab_niveau,
                                                          fann_key
                                                         )
AS
   SELECT UNIQUE h.fhab_key, dl.dlog_login, s.fdip_code, d.fgra_code,
                 h.fhab_niveau, dd.fann_key
            FROM scolarite.scol_droit_login dl,
                 scolarite.scol_droit_diplome dd,
                 scolarite.scol_formation_habilitation h,
                 scolarite.scol_formation_specialisation s,
                 scolarite.scol_formation_diplome d
           WHERE dd.dlog_key = dl.dlog_key
             AND h.fhab_key = dd.fhab_key
             AND h.fhab_ouvert = 'O'
             AND h.fann_key = dd.fann_key
             AND s.fspn_key = h.fspn_key
             AND d.fdip_code = s.fdip_code;

CREATE OR REPLACE FORCE VIEW scolarite.v_scol_inscription_ec (c_civilite,
                                                              no_individu,
                                                              nom_usuel,
                                                              prenom,
                                                              etud_numero,
                                                              mec_libelle,
                                                              mec_code,
                                                              mec_key,
                                                              annee_univ,
                                                              fann_key
                                                             )
AS
SELECT i.c_civilite, i.no_individu no_individu, i.nom_usuel, i.prenom,
                   idipl.etud_numero etud_numero, mec.mec_libelle mec_libelle,
                   mec.mec_code mec_code, mec.mec_key mec_key,
                      TO_CHAR (iec.fann_key)
                   || '-'
                   || TO_CHAR (iec.fann_key + 1) annee_univ,
                   idipl.fann_key fann_key
              FROM grhum.individu_ulr i,
                   scolarite.scol_inscription_etudiant idipl,
                   scolarite.scol_inscription_ec iec,
                   scolarite.scol_maquette_repartition_ec mre,
                   scolarite.scol_maquette_ec mec
             WHERE i.no_individu = idipl.no_individu
               AND idipl.idipl_numero = iec.idipl_numero
               AND iec.mrec_key = mre.mrec_key
               AND mre.mec_key = mec.mec_key;

CREATE OR REPLACE FORCE VIEW scolarite.v_trombi_formation (fann_key,
                                                           fhab_niveau,
                                                           fgra_code,
                                                           fgra_abreviation,
                                                           fdip_abreviation,
                                                           fspn_libelle,
                                                           fspn_key,
                                                           fdip_code,
                                                           fhab_key
                                                          )
AS
   SELECT h.fann_key, h.fhab_niveau, d.fgra_code, g.fgra_abreviation,
          d.fdip_abreviation, s.fspn_libelle, s.fspn_key, s.fdip_code,
          h.fhab_key
     FROM scol_formation_habilitation h,
          scol_formation_specialisation s,
          scol_formation_diplome d,
          scol_formation_grade g
    WHERE h.fspn_key = s.fspn_key
      AND s.fdip_code = d.fdip_code
      AND d.fgra_code = g.fgra_code
      AND h.fhab_ouvert = 'O'
   UNION
   SELECT h.fann_key, h.fhab_niveau, d.fgra_code, f.ffil_abreviation,
          d.fdip_abreviation, s.fspn_libelle, s.fspn_key, s.fdip_code,
          h.fhab_key
     FROM scol_formation_habilitation h,
          scol_formation_specialisation s,
          scol_formation_diplome d,
          scol_formation_filiere f
    WHERE h.fspn_key = s.fspn_key
      AND s.fdip_code = d.fdip_code
      AND d.fgra_code = f.ffil_code
      AND h.fhab_ouvert = 'O';
