import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}recommandProductManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}recommandProductManager/loadRecommandProduct/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}recommandProductManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}recommandProductManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBrand = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}recommandProductManager/requestCandidateBrand/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBrand = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}recommandProductManager/transferToAnotherBrand/id/anotherBrandId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCatalog = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}recommandProductManager/requestCandidateCatalog/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCatalog = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}recommandProductManager/transferToAnotherCatalog/id/anotherCatalogId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateProfile = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}recommandProductManager/requestCandidateProfile/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProfile = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}recommandProductManager/transferToAnotherProfile/id/anotherProfileId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}recommandProductManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}recommandProductManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const RecommandProductService = { view,
  load,
  requestCandidateParentCategory,
  requestCandidateBrand,
  requestCandidateCatalog,
  requestCandidateProfile,
  requestCandidatePlatform,
  transferToAnotherParentCategory,
  transferToAnotherBrand,
  transferToAnotherCatalog,
  transferToAnotherProfile,
  transferToAnotherPlatform }
export default RecommandProductService

